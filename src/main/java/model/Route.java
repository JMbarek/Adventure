package model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

/**
 * Created by jaouhar.mbarek on 25.02.2017.
 */
@JacksonXmlRootElement(localName = "route")
public class Route {

    @JacksonXmlProperty(localName = "room")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<RouteRoom> rooms;

    public List<RouteRoom> getRooms() {
        return rooms;
    }

    public void setRooms(List<RouteRoom> rooms) {
        this.rooms = rooms;
    }
}
