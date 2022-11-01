package cardsearchservice;

import enitites.Card;

import java.util.List;

public interface CardsSearchService {


    List<Card> getCardsContainingLabel(String label);
}
