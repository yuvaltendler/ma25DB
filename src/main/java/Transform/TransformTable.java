package Transform;

import org.json.simple.JSONObject;

public class TransformTable {
    public static void updateCell(JSONObject table, int recordInx, String colName, Object newData){
        JSONObject record = ParseTable.getRecord(table, recordInx);
        if(ParseTable.getColType(table, colName).equals("Int")){
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
}
