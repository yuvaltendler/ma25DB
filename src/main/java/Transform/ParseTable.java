package Transform;

import org.json.simple.JSONObject;

public class ParseTable {
    public static JSONObject getRecord(JSONObject table, int recordInx){
        JSONObject data = (JSONObject) table.get("Table");
        return (JSONObject) data.get(String.valueOf(recordInx));

    }

    public static Object getCell(JSONObject table, int recordInx, String colName){
        return getRecord(table, recordInx).get(colName);
    }

    public static String getColType(JSONObject table, String colName){
        JSONObject settings = (JSONObject) table.get("Settings");
        return (String) settings.get(colName);
    }

    public static JSONObject getData(JSONObject table){
        return (JSONObject) table.get("Table");
    }

    public static JSONObject getSettings(JSONObject table){
        return (JSONObject) table.get("Settings");
    }
}
