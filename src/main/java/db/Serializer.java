package db;

import model.Route;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by jaouhar.mbarek on 26.02.2017.
 */
public class Serializer {

    private String xmlFilePath;
    private Route route;

    public Serializer(String xmlFilePath, Route route) {
        this.xmlFilePath = xmlFilePath;
        this.route = route;
    }

    public void serializeToXmlFile() throws IOException {
        ObjectMapper xmlMapper = new XmlMapper();
        File file = new File(xmlFilePath);
        xmlMapper.writeValue(file, route);
    }
}
