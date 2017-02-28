import Controller.factory.ConfigFactory;
import Controller.factory.DeserializerFactory;
import db.ConfigFile;
import db.Deserializer;
import model.Map;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by jaouhar.mbarek on 27.02.2017.
 */
public class TestRunner {

    // Initialize
    @BeforeClass
    public static void before() {
    }

    // Check if a config file can be read properly.
    @Test
    public void readingFromConfigFileTest() {
        //Arrange
        ConfigFactory configFactory = new ConfigFactory("input/config1.txt");
        //Act
        ConfigFile configFile = configFactory.getConfiguration();
        configFile.readFile();
        String testStartingRoom = configFile.getStartRoom();
        String firstObjectToCollect = configFile.getObjects().get(0);
        String secondObjectToCollect = configFile.getObjects().get(1);

        //Assert
        assertEquals(testStartingRoom, "1");
        assertEquals(firstObjectToCollect, "Scarf");
        assertEquals(secondObjectToCollect, "Soap");
    }

    // check if the Deserialization is working correctly
    @Test
    public void deserializationTest() {
        //Arrange
        DeserializerFactory deserializerFactory = new DeserializerFactory("input/map.xml");
        Deserializer deserializer = deserializerFactory.getDeserializer();
        Map map = null;
        //Act
        try {
            map = deserializer.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Assert
        assertNotNull("the returned Map after parsing is null", map);
        assertTrue("the \"room.size()\" are not like expected", map.getRooms().size() == 8);
        assertTrue("the \"room.object.size()\" are not like expected", map.getRooms().get(1).getObjects().size() == 2);
        assertTrue("the Field \"room.object.name\" is not like expected", map.getRooms().get(1).getObjects().get(0).getName().equals("Scarf"));
    }


    // Check if all the in config objects are collected.
    @Test
    public void allObjectsInConfigAreCollectedTest() {
        //Arrange
        Controller.Runner run = new Controller.Runner();
        //Act
        try {
            run.execute("input/map.xml", "input/config1.txt", "output/route.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> collectedObjects = run.collectedObjects;
        List<String> objectsToCollect = new ArrayList<>(
                Arrays.asList("Scarf", "Soap"));
        collectedObjects.removeAll(objectsToCollect);
        //Assert
        assertTrue("The collected objects are not like in Config File", collectedObjects.size() == 0);
    }
}
