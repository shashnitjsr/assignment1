package store;

import enitites.Card;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CardStore {
    Map<String, Card> cardMap = new HashMap<>();
    private static CardStore cardStore = new CardStore();

    private CardStore() {

    }

    public static CardStore getInstance() {
        return cardStore;
    }

    public void addCard(Card card) {
        cardMap.put(card.getId(), card);
    }

    public Card getCard(String id) {
        return cardMap.get(id);
    }

    public Set<String> getAllCardIds() {
        return cardMap.keySet();
    }
}
