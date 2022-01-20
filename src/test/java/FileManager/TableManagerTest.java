package FileManager;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

class TableManagerTest {

    @Test
    void testGetTable() throws ParseException, IOException {
        final String path = "C:\\Users\\user\\Documents\\Army\\codes\\ma25DB\\src\\main\\resources\\DB\\T1.json";
        TableManager tableManager = TableManager.getInstance(10);
        HashMap<String, ArrayList<String>> tableNameToPaths = new HashMap<String, ArrayList<String>>(){{
            ArrayList<String> list = new ArrayList<String>(){{add(path);}};
            put("T1", list);
        }};
        tableManager.setTableNameToPaths(tableNameToPaths);
        ArrayList<JSONObject> res = tableManager.getTable("T1");

        final JSONParser parser = new JSONParser();
        ArrayList<JSONObject> expected = new ArrayList<JSONObject>(){{
            add((JSONObject) parser.parse(new FileReader(path)));
        }};
        assert res.equals(expected);
    }
}