package dao;

import model.Room;
import model.Object;

import java.util.List;

/**
 * Created by jaouhar.mbarek on 26.02.2017.
 */
public interface ObjectDao {
    List<Object> getAllObjectsFromMapRoom(Room room);
    void addObjectsToRouteRoom(List<Object> objects, Room room);
    void deleteObjectsFromMapRoom(List<Object> objects, Room room);
}
