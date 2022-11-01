package cardservice;

import enitites.Card;
import enitites.Label;
import enitites.User;
import store.CardStore;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
        List<Card> cards = new LinkedList<>();
        Set<String> allCardIds = cardStore.getAllCardIds();
        for(String cardId: allCardIds) {
            Card card = cardStore.getCard(cardId);
            if(card.getCreatedTimeInMillis() > timeInMillis) {
                cards.add(card);
            }
        }
        return cards;
    }

    @Override
    public List<Card> getCardsHighlightedForAUser(User user) {
        return cardStore.getAllCardIds().stream()
                .map(id -> cardStore.getCard(id))
                .filter(card -> card.getUser().getId().equals(user.getId()) && card.getLastUpdatedTimeInMillis() > user.getLastVisitedTimeInMillis())
                .collect(Collectors.toList());
      }
}
