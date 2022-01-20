package Transform;

import FileManager.TableManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class TransformTableTest {

    @Test
    void updateCell() {
        final String path = "C:\\Users\\user\\Documents\\Army\\codes\\ma25DB\\src\\main\\resources\\DB\\T1.json";
        TableManager tableManager = TableManager.getInstance(10);
        ArrayList<String> list = new ArrayList<String>(){{add(path);}};
        tableManager.addNewTable("T1", list);

        JSONObject t1 = tableManager.getTableByRow("T1", 2);
        TransformTable.updateCell(t1, 2, "id", 375486521);
        assert ((Integer) ParseTable.getCell(t1, 2, "id")).equals(375486521);
        System.out.println(t1.toJSONString());
    }

    @Test
    void updateRecord() throws ParseException {
        final String path = "C:\\Users\\user\\Documents\\Army\\codes\\ma25DB\\src\\main\\resources\\DB\\T1.json";
        TableManager tableManager = TableManager.getInstance(10);
        ArrayList<String> list = new ArrayList<String>(){{add(path);}};
        tableManager.addNewTable("T1", list);
        JSONObject t1 = tableManager.getTableByRow("T1", 2);

        final JSONParser parser = new JSONParser();
        JSONObject recordToAdd = (JSONObject) parser.parse("{\"firstName\": \"name4\", \"lastName\": \"name4\", \"id\": 987654321, \"birthday\": \"2014-01-05\"}");
        TransformTable.updateRecord(t1, 3, recordToAdd);
        assert ParseTable.getRecord(t1, 3).equals(recordToAdd);
    }

    @Test
    void insertRecord() throws ParseException {
        final String path = "C:\\Users\\user\\Documents\\Army\\codes\\ma25DB\\src\\main\\resources\\DB\\T1.json";
        TableManager tableManager = TableManager.getInstance(10);
        ArrayList<String> list = new ArrayList<String>(){{add(path);}};
        tableManager.addNewTable("T1", list);
        JSONObject t1 = tableManager.getTableByRow("T1", 2);

        final JSONParser parser = new JSONParser();
        JSONObject recordToAdd = (JSONObject) parser.parse("{\"firstName\": \"name4\", \"lastName\": \"name4\", \"id\": 987654321, \"birthday\": \"2014-01-05\"}");
        TransformTable.insertRecord(t1, recordToAdd);
        assert ParseTable.getRecord(t1, 4).equals(recordToAdd);
    }

    @Test
    void dropRecord(){
        final String path = "C:\\Users\\user\\Documents\\Army\\codes\\ma25DB\\src\\main\\resources\\DB\\T1.json";
        TableManager tableManager = TableManager.getInstance(10);
        ArrayList<String> list = new ArrayList<String>(){{add(path);}};
        tableManager.addNewTable("T1", list);
        JSONObject t1 = tableManager.getTableByRow("T1", 2);

        TransformTable.dropRecord(t1, 2);
        assert ParseTable.getData(t1).size() == 2;
    }
}