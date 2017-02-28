package Controller.factory;

import dao.RoomDao;
import dao.impl.RoomDaoImpl;
import model.Map;

/**
 * Created by jaouhar.mbarek on 27.02.2017.
 */
public class RoomDaoFactory {

    private Map map;

    public RoomDaoFactory(Map map) {
        this.map = map;
    }

    public RoomDao getRoomDao( ) {
        return new RoomDaoImpl(map);
    }
}
