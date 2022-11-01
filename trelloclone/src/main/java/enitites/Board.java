package enitites;

import java.util.Map;

public class Board {

    private String id;
    Map<String, Column> columnMap;

    public Board(String id, Map<String, Column> columnMap) {
        this.id = id;
        this.columnMap = columnMap;
    }

    public Board() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Column> getColumnMap() {
        return columnMap;
    }

    public void setColumnMap(Map<String, Column> columnMap) {
        this.columnMap = columnMap;
    }
}
