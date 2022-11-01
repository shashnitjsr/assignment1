package enitites;

import java.util.Map;

public class Card {

    private String id;
    private Map<String, Label> labelMap;
    private long createdTimeInMillis;
    private long lastUpdatedTimeInMillis;
    private User user;

    public Card() {
    }

    public Card(String id, Map<String, Label> labelMap, long createdTimeInMillis, long lastUpdatedTimeInMillis,
                User user) {
        this.id = id;
        this.labelMap = labelMap;
        this.createdTimeInMillis = createdTimeInMillis;
        this.lastUpdatedTimeInMillis = lastUpdatedTimeInMillis;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Label> getLabelMap() {
        return labelMap;
    }

    public void setLabelMap(Map<String, Label> labelMap) {
        this.labelMap = labelMap;
    }

    public long getLastUpdatedTimeInMillis() {
        return lastUpdatedTimeInMillis;
    }

    public void setLastUpdatedTimeInMillis(long lastUpdatedTimeInMillis) {
        this.lastUpdatedTimeInMillis = lastUpdatedTimeInMillis;
    }

    public long getCreatedTimeInMillis() {
        return createdTimeInMillis;
    }

    public void setCreatedTimeInMillis(long createdTimeInMillis) {
        this.createdTimeInMillis = createdTimeInMillis;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
