package enitites;

import java.util.Map;

public class Column {

    private String id;
    Map<String, Label> cardMap;

    public Column(String id, Map<String, Label> cardMap) {
        this.id = id;
        this.cardMap = cardMap;
    }

    public Column() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Label> getCardMap() {
        return cardMap;
    }

    public void setCardMap(Map<String, Label> cardMap) {
        this.cardMap = cardMap;
    }
}
