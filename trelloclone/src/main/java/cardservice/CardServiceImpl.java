package cardservice;

import enitites.Card;
import enitites.Label;
import store.CardStore;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CardServiceImpl implements CardService {

    private CardStore cardStore = CardStore.getInstance();

    @Override
    public List<Card> getCardsContainingLabel(String label) {

        List<Card> cards = new LinkedList<>();
        Set<String> allCardIds = cardStore.getAllCardIds();
        for(String cardId: allCardIds) {
            Card card = cardStore.getCard(cardId);
            Map<String , Label> labelMap = card.getLabelMap();
            for(Map.Entry<String, Label> labelEntry: labelMap.entrySet()) {
                if (labelEntry.getValue().getLabel().equals(label)) {
                    cards.add(card);
                }
            }
        }
        return cards;
    }

    @Override
    public List<Card> getCardsCreatedAfterGivenTimeStamp(long timeInMillis) {
        return null;
    }
}
