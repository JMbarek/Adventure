package db;

import model.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

/**
 * Created by jaouhar.mbarek on 26.02.2017.
 */
public class Deserializer {

    private String xmlFilePath;

    public Deserializer(String xmlFilePath) {
        this.xmlFilePath = xmlFilePath;
    }

    public static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    public Map parse() throws IOException {
        ObjectMapper xmlMapper = new XmlMapper();
        File file = new File(xmlFilePath);
        String xml = inputStreamToString(new FileInputStream(file));
        Map map = xmlMapper.readValue(xml, Map.class);
        return map;
    }
}
