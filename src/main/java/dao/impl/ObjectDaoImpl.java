package dao.impl;

import model.Room;
import model.Object;
import dao.ObjectDao;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by jaouhar.mbarek on 26.02.2017.
 */
public class ObjectDaoImpl implements ObjectDao {

    private RoomDaoImpl roomImp;

    public ObjectDaoImpl(RoomDaoImpl roomImp) {
        this.roomImp = roomImp;
    }

    @Override
    public List<Object> getAllObjectsFromMapRoom(Room room) {
        return roomImp.getRoomFromMap(room.getId()).getObjects();
    }

    @Override
    public void addObjectsToRouteRoom(List<Object> objects, Room room) {
        roomImp.getRoomFromRoute(room.getId()).setObjects(objects);
    }

    @Override
    public void deleteObjectsFromMapRoom(List<Object> objects, Room room) {
        List<Object> objList = roomImp.getRoomFromMap(room.getId()).getObjects();
        for (ListIterator<Object> iterator = objList.listIterator(); iterator.hasNext(); ) {
            Object ob1 = iterator.next();
            objects.stream().filter(ob2 -> ob1.getName().equals(ob2.getName())).forEach(ob2 -> {
                iterator.remove();
            });
        }
    }
}
