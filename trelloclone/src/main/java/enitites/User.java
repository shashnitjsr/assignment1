package enitites;

public class User {
    private String id;
    private long lastVisitedTimeInMillis;

    public User(String id, long lastVisitedTimeInMillis) {
        this.id = id;
        this.lastVisitedTimeInMillis = lastVisitedTimeInMillis;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getLastVisitedTimeInMillis() {
        return lastVisitedTimeInMillis;
    }

    public void setLastVisitedTimeInMillis(long lastVisitedTimeInMillis) {
        this.lastVisitedTimeInMillis = lastVisitedTimeInMillis;
    }
}
