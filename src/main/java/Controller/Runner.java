package Controller;

import Controller.factory.*;
import dao.ObjectDao;
import dao.RoomDao;
import dao.impl.RoomDaoImpl;
import db.ConfigFile;
import db.Deserializer;
import db.Serializer;
import model.Map;
import model.Object;
import model.Room;
import model.Route;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jaouhar.mbarek on 25.02.2017.
 */
public class Runner {

    public static List<String> collectedObjects;

    /**
     * choose randomly a room from the adjoining rooms
     *
     * @param room the visited room
     * @return Id of an adjoining Room
     */
    public static String getRandomlyAdjoiningRoom(Room room) {
        List<String> adjoiningRooms = new ArrayList<String>();
        if (room.getSouth() != null) {
            adjoiningRooms.add(room.getSouth());
        }
        if (room.getNorth() != null) {
            adjoiningRooms.add(room.getNorth());
        }
        if (room.getEast() != null) {
            adjoiningRooms.add(room.getEast());
        }
        if (room.getWest() != null) {
            adjoiningRooms.add(room.getWest());
        }
        // shuffle the list
        Collections.shuffle(adjoiningRooms);
        // return the first RoomId in the list
        return adjoiningRooms.get(0);
    }

    /**
     * get the Model.Object.names from a List of Model.Object type.
     *
     * @param objList the Object Lsit
     * @return String List includes all the names
     */
    public static List<String> getObjectsNames(List<Object> objList) {
        List<String> objectsNames = new ArrayList<>();
        for (int i = 0; i < objList.size(); i++) {
            objectsNames.add(objList.get(i).getName());
        }
        return objectsNames;
    }

    /**
     * convert a List of Strings(Model.Object.name) to a List of type Model.Object.
     *
     * @param names name of the objects in String type
     * @return list of Model.Object type.
     */
    public static List<Object> toObjectList(List<String> names) {
        List<Object> objectList = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            Object ob = new Object();
            ob.setName(names.get(i));
            objectList.add(ob);
        }
        return objectList;
    }

    /**
     * main method where the logic is implemented.
     *
     * @param args0 the map.xml file (input)
     * @param args1 the config.txt file (input)
     * @param args2 the route.txt file (output)
     * @throws IOException
     */
    public static void execute(String args0, String args1, String args2) throws IOException {
        //get the Deserializer class using its Factory class
        DeserializerFactory deserializerFactory = new DeserializerFactory(args0);
        Deserializer deserializer = deserializerFactory.getDeserializer();
        // parse the XML to Map Class.
        Map map = deserializer.parse();
        Route route = new Route();

        ConfigFactory configFactory = new ConfigFactory(args1);
        ConfigFile cf = configFactory.getConfiguration();
        // This method is to read the config.txt
        cf.readFile();
        // get the StartRoom
        String startRoomId = cf.getStartRoom();

        // list of the objects to collect.
        List<String> objectsToCollect = cf.getObjects();
        //list of the collected objects, it's empty at the beginning
        collectedObjects = new ArrayList<>();

        // get RoomDao (Data Access Object) using its Factory class
        RoomDaoFactory roomDaoFactory = new RoomDaoFactory(map);
        RoomDao roomDao = roomDaoFactory.getRoomDao();
        // get objectDao using its Factory class
        ObjectDaoFactory objectDaoFactory = new ObjectDaoFactory((RoomDaoImpl) roomDao);
        ObjectDao objectDao = objectDaoFactory.getObjectDao();
        // actual Room represents the visited Room in every iteration, firstly it takes the startRoom from the ConfigFile
        Room actualRoom = roomDao.getRoomFromMap(startRoomId);
        while (!objectsToCollect.isEmpty()) {

            List<Object> objList = objectDao.getAllObjectsFromMapRoom(actualRoom);

            if (objList != null && !objList.isEmpty()) {
                List<String> objectsInActualRoom = getObjectsNames(objList);
                // check if there are Objects to collect in the actual visited room
                objectsInActualRoom.retainAll(objectsToCollect);

                // if objects to collect are existing, add the room to the the route and add the found objects to this route.room
                if (!objectsInActualRoom.isEmpty()) {
                    collectedObjects.addAll(objectsInActualRoom);
                    //add room to route
                    roomDao.addRoomToRoute(actualRoom, collectedObjects);
                    // add objects to route.room
                    objectDao.addObjectsToRouteRoom(toObjectList(objectsInActualRoom), actualRoom);
                    // VERY IMPORTANT: delete the found objects from map.room to avoid duplicated found objects in route.
                    objectDao.deleteObjectsFromMapRoom(toObjectList(objectsInActualRoom), actualRoom);
                    // remove the found Objects from objectsToCollect list.
                    objectsToCollect.removeAll(objectsInActualRoom);
                } else {
                    // if objects to collect are not existing, only add the visited room to the route.
                    roomDao.addRoomToRoute(actualRoom, collectedObjects);
                }
            } else {
                // if there are no objects in the visited room, only add the visited room to the route.
                roomDao.addRoomToRoute(actualRoom, collectedObjects);
            }
            // choose randomly the next room to visit from the Map
            Room nextRoom = roomDao.getRoomFromMap(getRandomlyAdjoiningRoom(actualRoom));
            // and assign it to the actual room
            actualRoom = nextRoom;
        }
        // at the end set all the visited rooms with the collected objects to the route.
        route.setRooms(roomDao.getAllRoomsFromRoute());

        //get the Serializer class using its Factory class
        SerializerFactory serializerFactory = new SerializerFactory(args2, route);
        Serializer serializer = serializerFactory.getSerializer();
        // serialize the route Object to route.xml data.
        serializer.serializeToXmlFile();
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            System.out.println("please provide all the required parameters");
        } else {
            execute(args[0], args[1], args[2]);
        }
    }
}
