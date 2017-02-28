package dao.impl;

import model.*;
import model.Object;
import dao.RoomDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaouhar.mbarek on 26.02.2017.
 */
public class RoomDaoImpl implements RoomDao {

    List<Room> mapRooms;
    List<RouteRoom> routeRooms;

    public RoomDaoImpl(Map map) {
        routeRooms = new ArrayList<>();
        this.mapRooms = map.getRooms();
    }


    @Override
    public List<RouteRoom> getAllRoomsFromRoute() {
        return routeRooms;
    }

    @Override
    public Room getRoomFromMap(String id) {
        Room r = null;
        for (int i = 0; i < mapRooms.size(); i++) {
            if (mapRooms.get(i).getId().equals(id)) {
                r = mapRooms.get(i);
            }
        }
        if (r != null) return r;
        else {
            return null;
        }
    }

    @Override
    public RouteRoom getRoomFromRoute(String id) {
        RouteRoom r = null;
        for (int i = 0; i < routeRooms.size(); i++) {
            if (routeRooms.get(i).getId().equals(id)) {
                r = routeRooms.get(i);
            }
        }
        if (r != null) return r;
        else {
            return null;
        }
    }

    @Override
    public void addRoomToRoute(Room room, List<String> collectedObjects) {
        RouteRoom r = new RouteRoom();
        boolean isExisting = false;
        if (!collectedObjects.isEmpty() && room.getObjects() != null) {
            for (Object o : room.getObjects()) {
                if (collectedObjects.contains(o.getName())) {
                    isExisting = true;
                }
            }
        }
        //this Step is very important: set null to Objects which belongs to a room that doesn't include objects to collect.
        if (!isExisting) {
            r.setObjects(null);
        } else {
            r.setObjects(room.getObjects());
        }
        r.setId(room.getId());
        r.setName(room.getName());
        routeRooms.add(r);
    }

}
