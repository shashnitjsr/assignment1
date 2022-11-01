package columndisplay;

import enitites.Card;
import java.util.List;

public interface ColumnDisplayService {

    List<Card> displayCardsInColumn(String columnId);

}
