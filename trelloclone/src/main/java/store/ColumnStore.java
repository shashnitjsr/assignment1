package store;

import enitites.Column;
import java.util.HashMap;
import java.util.Map;

public class ColumnStore {
    Map<String, Column> columnMap = new HashMap<>();
    private static ColumnStore columnStore = new ColumnStore();

    private ColumnStore() {

    }

    public static ColumnStore getInstance() {
        return columnStore;
    }

    public void addColumn(Column column) {
        columnMap.put(column.getId(), column);
    }

    public Column getColumn(String id) {
        return columnMap.get(id);
    }
}
