package store;

import enitites.Label;
import java.util.HashMap;
import java.util.Map;

public class LabelStore {
    Map<String, Label> labelMap = new HashMap<>();
    private static LabelStore labelStore = new LabelStore();

    private LabelStore() {

    }

    public static LabelStore getInstance() {
        return labelStore;
    }

    public void addLabel(Label label) {
        labelMap.put(label.getId(), label);
    }

    public Label getLabel(String id) {
        return labelMap.get(id);
    }
}
