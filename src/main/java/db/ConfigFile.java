package db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaouhar.mbarek on 26.02.2017.
 */
public class ConfigFile {

    private String filePath;
    private List<String> objects;
    private List<String> lines;
    private String startRoom;

    public ConfigFile(String filePath) {
        this.filePath = filePath;
    }

    public void readFile() {
        BufferedReader br;
        lines = new ArrayList<>();
        String line;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                lines.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getObjects() {
        if (!lines.isEmpty() && lines.size() >= 2) {
            objects = new ArrayList<>();
            objects = lines.subList(1, lines.size());
            return objects;
        } else {
            return null;
        }
    }

    public String getStartRoom() {
        if (!lines.isEmpty()) {
            startRoom = lines.get(0);
            return startRoom;
        } else {
            return null;
        }
    }
}
