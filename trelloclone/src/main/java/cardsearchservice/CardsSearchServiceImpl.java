package cardsearchservice;

import enitites.Card;
import store.CardStore;

import java.util.List;

public class CardsSearchServiceImpl implements CardsSearchService {

    private CardStore cardStore = CardStore.getInstance();

    @Override
    public List<Card> getCardsContainingLabel(String label) {
        return null;
    }
}
