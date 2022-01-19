package FileManager;

import lombok.Getter;
import lombok.Setter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TableManager {
    private static TableManager instance;

    private final int MUX_RECORD_IN_FILE;
    private @Getter @Setter HashMap<String, ArrayList<String>> tableNameToPaths;

    public JSONObject getTableByRow(String tableName, int row){
        return this.getTableByIndex(tableName, row/MUX_RECORD_IN_FILE);
    }

    public ArrayList<JSONObject> getTable(String tableName){
        ArrayList<JSONObject> res = new ArrayList<>();
        for(int i = 0; i < this.tableNameToPaths.get(tableName).size(); i++){
            res.add(this.getTableByIndex(tableName, i));
        }
        return res;
    }

    private JSONObject getTableByIndex(String tableName, int inx){
        JSONParser jsonParser = new JSONParser();
        try {
            Object obj  = jsonParser.parse(new FileReader(String.valueOf(new FileReader(this.tableNameToPaths.get(tableName).get(inx)))));
            return (JSONObject) obj;


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private TableManager(int mux_record_in_file){
        MUX_RECORD_IN_FILE = mux_record_in_file;
    }

    public static TableManager getInstance(int mux_record_in_file){
        if(instance == null){
            instance = new TableManager(mux_record_in_file);
        }
        return instance;
    }

    public static TableManager getInstance(){
        if(instance != null){
            return instance;
        }
        return null;
    }
}
