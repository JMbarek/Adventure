package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

/**
 * Created by jaouhar.mbarek on 25.02.2017.
 */
public class Room {


    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "object")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private List<Object> objects;

    @JacksonXmlProperty(isAttribute = true)
    private String id;
    @JacksonXmlProperty(isAttribute = true)
    private String name;
    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String north;
    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String south;
    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String west;
    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String east;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNorth() {
        return north;
    }

    public void setNorth(String north) {
        this.north = north;
    }

    public String getSouth() {
        return south;
    }


    public void setSouth(String south) {
        this.south = south;
    }

    public String getWest() {
        return west;
    }


    public void setWest(String west) {
        this.west = west;
    }

    public String getEast() {
        return east;
    }


    public void setEast(String east) {
        this.east = east;
    }

    public List<Object> getObjects() {
        return objects;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }
}
