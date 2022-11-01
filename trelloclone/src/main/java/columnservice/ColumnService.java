package columnservice;

import enitites.Card;
import java.util.List;

public interface ColumnService {

    List<Card> displayCardsInColumn(String columnId);

}
