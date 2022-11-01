package cardsearchservicetest;

import cardsearchservice.CardsSearchService;
import cardsearchservice.CardsSearchServiceImpl;
import enitites.Card;
import enitites.Label;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import store.CardStore;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "store.*")
public class CardSearchServiceTest {

    @Mock
    CardStore cardStore;

    @InjectMocks
    CardsSearchService cardSearchService = new CardsSearchServiceImpl();

    @Before
    public void beforeAll() {
        mockStatic(CardStore.class);
    }

    @Test
    public void testCardSearchService() {
        Label label1 = new Label("test1", "label1");
        Label label2 = new Label("test2", "label2");
        Card card1 = new Card();
        Card card2 = new Card();

        Map<String, Label> labelMap1 = new HashMap<>();
        labelMap1.put("test1", label1);

        Map<String, Label> labelMap2 = new HashMap<>();
        labelMap2.put("test2", label2);

        card1.setLabelMap(labelMap1);
        card1.setId("test1");
        card2.setLabelMap(labelMap2);
        card2.setId("test2");

        Set<String> cardIds = new HashSet<>();
        cardIds.add("test1");
        cardIds.add("test2");

        when(CardStore.getInstance()).thenReturn(cardStore);
    //    doReturn(cardStore).when(CardStore.getInstance());
        when(cardStore.getAllCardIds()).thenReturn(cardIds);
        when(cardStore.getCard("test1")).thenReturn(card1);
        when(cardStore.getCard("test2")).thenReturn(card2);

        Assert.assertEquals(cardSearchService.getCardsContainingLabel("label1").size(), 1);
    }

}
