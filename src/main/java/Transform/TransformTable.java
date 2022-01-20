package Transform;

import org.json.simple.JSONObject;

public class TransformTable {
    public static void updateCell(JSONObject table, int recordInx, String colName, Object newData){
        JSONObject record = ParseTable.getRecord(table, recordInx);
        if(ParseTable.getSetting(table, colName).equals("Int")){
            record.put(colName, (Integer)newData);
        }
        else if (newData instanceof String) {
            record.put(colName, (String)newData);
        }
        table.put(String.valueOf(recordInx), record);
    }

    public static void updateRecord(JSONObject table, int recordInx, JSONObject newRecord){
        JSONObject data = ParseTable.getData(table);
        data.put(String.valueOf(recordInx), newRecord);
        table.put("Table", data);
    }

    public static void insertRecord(JSONObject table, JSONObject newRecord){
        JSONObject data = ParseTable.getData(table);
        String keyString = ParseTable.getSetting(table, "nextKey");
        data.put(keyString, newRecord);
        table.put("Table", data);
        JSONObject settings = ParseTable.getSettings(table);
        int key = Integer.parseInt(keyString);
        String nextKey = String.valueOf(key += 1);
        settings.put("nextKey", nextKey);
        table.put("Settings", settings);
    }

    public static void dropRecord(JSONObject table, int recordInx){
        JSONObject data = ParseTable.getData(table);
        data.remove(String.valueOf(recordInx));
        table.put("Table", data);
    }
}
