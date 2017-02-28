package Controller.factory;

import dao.ObjectDao;
import dao.impl.ObjectDaoImpl;
import dao.impl.RoomDaoImpl;

/**
 * Created by jaouhar.mbarek on 27.02.2017.
 */
public class ObjectDaoFactory {
    private RoomDaoImpl roomImpl;

    public ObjectDaoFactory(RoomDaoImpl roomImpl) {
        this.roomImpl = roomImpl;
    }

    public ObjectDao getObjectDao() {
        return new ObjectDaoImpl(roomImpl);
    }
}
