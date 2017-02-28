package dao;

import model.Room;
import model.RouteRoom;

import java.util.List;

/**
 * Created by jaouhar.mbarek on 26.02.2017.
 */
public interface RoomDao {
    List<RouteRoom> getAllRoomsFromRoute();
    Room getRoomFromMap(String id);
    RouteRoom getRoomFromRoute(String id);
    void addRoomToRoute(Room roomList, List<String> collectedObjects);
}
