package Controller.factory;

import db.Serializer;
import model.Route;

/**
 * Created by jaouhar.mbarek on 27.02.2017.
 */
public class SerializerFactory {

    private String xmlPath;
    private Route route;

    public SerializerFactory(String xmlPath, Route route) {
        this.xmlPath = xmlPath;
        this.route = route;
    }

    public Serializer getSerializer() {
        return new Serializer(xmlPath, route);
    }
}
