package columnservice;

import enitites.Card;
import enitites.Column;
import store.ColumnStore;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ColumnServiceImpl implements ColumnService {

    private ColumnStore columnStore = ColumnStore.getInstance();

    @Override
    public List<Card> displayCardsInColumn(String columnId) {
        Column column = columnStore.getColumn(columnId);
        List<Card> cardList = new LinkedList<>();
        for(Map.Entry<String, Card> entry: column.getCardMap().entrySet()) {
            cardList.add(entry.getValue());
        }
        return cardList;
    }
}
