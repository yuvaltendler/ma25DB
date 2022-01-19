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

public class FileManager {
    private static FileManager instance;

    private final int MUX_RECORD_IN_FILE;
    private @Getter @Setter HashMap<String, ArrayList<String>> tableNameToPaths;

    public JSONObject getTableByRow(String tableName, int row){
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(this.tableNameToPaths.get(tableName).get(row/MUX_RECORD_IN_FILE)))
        {
            Object obj = jsonParser.parse(reader);
            return (JSONObject) obj;

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private FileManager(int mux_record_in_file){
        MUX_RECORD_IN_FILE = mux_record_in_file;
    }

    public static FileManager getInstance(int mux_record_in_file){
        if(instance == null){
            instance = new FileManager(mux_record_in_file);
        }
        return instance;
    }

    public static FileManager getInstance(){
        if(instance != null){
            return instance;
        }
        return null;
    }
}
