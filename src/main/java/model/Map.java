package model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

/**
 * Created by jaouhar.mbarek on 25.02.2017.
 */
@JacksonXmlRootElement(localName = "map")
public class Map {

    @JacksonXmlProperty(localName = "room")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Room> rooms;

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
