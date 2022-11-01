package enitites;

public class Label {

    private String id;
    private String label;

    public Label(String id, String label) {
        this.id = id;
        this.label = label;
    }

    public Label() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
