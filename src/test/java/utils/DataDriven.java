package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.io.InputStreamReader;

public class DataDriven {

    public static JSONObject jsonReader() throws Exception {

        JSONParser parser = new JSONParser();

        InputStream input = DataDriven.class
                .getClassLoader()
                .getResourceAsStream("testData.json");

        if (input == null) {
            throw new RuntimeException("❌ File not found: testData.json");
        }

        InputStreamReader reader = new InputStreamReader(input);

        return (JSONObject) parser.parse(reader);
    }
}