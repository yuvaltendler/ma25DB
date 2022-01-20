package Transform;

import FileManager.TableManager;
import org.json.simple.JSONObject;
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
        t1 = TransformTable.updateCell(t1, 2, "id", 375486521);
        assert ((Integer) ParseTable.getCell(t1, 2, "id")).equals(375486521);
        System.out.println(t1.toJSONString());
    }
}