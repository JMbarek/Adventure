package Controller.factory;

import db.Deserializer;

/**
 * Created by jaouhar.mbarek on 27.02.2017.
 */
public class DeserializerFactory {

    private String xmlPath;

    public DeserializerFactory(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public Deserializer getDeserializer() {
        return new Deserializer(xmlPath);
    }
}
