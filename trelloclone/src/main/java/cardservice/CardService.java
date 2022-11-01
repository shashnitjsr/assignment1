package cardservice;

import enitites.Card;

import java.util.List;

public interface CardService {

    List<Card> getCardsContainingLabel(String label);

    List<Card> getCardsCreatedAfterGivenTimeStamp(long timeInMillis);

}
