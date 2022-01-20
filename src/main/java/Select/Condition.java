package Select;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

@Data
@Builder
public class Condition {
    private Comparable value;
    private ArrayList<String> equal;
    private ArrayList<String> biggerThenValue;
    private ArrayList<String> SmallerThenValue;

    public boolean isRecordPassCondition(JSONObject record){
        for(String colName: equal){
            if(value != record.get(colName)){
                return false;
            }
        }
        return true;
    }
}
