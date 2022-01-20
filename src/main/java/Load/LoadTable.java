package Load;

import FileManager.TableManager;

public class LoadTable {
    private static LoadTable instance;

    private TableManager tableManager = TableManager.getInstance();

    private LoadTable(){}

    public static LoadTable getInstance(){
        if(instance == null){
            instance = new LoadTable();
        }
        return instance;
    }
}
