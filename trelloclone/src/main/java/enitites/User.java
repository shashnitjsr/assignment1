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
}
