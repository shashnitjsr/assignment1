package enitites;

import java.util.Map;

public class Column {

    private String id;
    private Map<String, Card> cardMap;

    public Column(String id, Map<String, Card> cardMap) {
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

    public Map<String, Card> getCardMap() {
        return cardMap;
    }

    public void setCardMap(Map<String, Card> cardMap) {
        this.cardMap = cardMap;
    }
}
