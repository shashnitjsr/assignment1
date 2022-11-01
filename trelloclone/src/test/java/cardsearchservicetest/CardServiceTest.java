package cardsearchservicetest;

import cardservice.CardServiceImpl;
import enitites.Card;
import enitites.Label;
import enitites.User;
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
public class CardServiceTest {

    @Mock
    CardStore cardStore;

    @InjectMocks
    cardservice.CardService cardSearchService = new CardServiceImpl();

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
        when(cardStore.getAllCardIds()).thenReturn(cardIds);
        when(cardStore.getCard("test1")).thenReturn(card1);
        when(cardStore.getCard("test2")).thenReturn(card2);

        Assert.assertEquals(1, cardSearchService.getCardsContainingLabel("label1").size());
    }


    @Test
    public void testCardCreatedAfterGivenTimeStamp() {

        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();

        card1.setId("test1");
        card2.setId("test2");
        card3.setId("test3");

        card1.setCreatedTimeInMillis(4);
        card2.setCreatedTimeInMillis(6);
        card3.setCreatedTimeInMillis(7);

        Set<String> cardIds = new HashSet<>();
        cardIds.add("test1");
        cardIds.add("test2");
        cardIds.add("test3");

        when(CardStore.getInstance()).thenReturn(cardStore);
        when(cardStore.getAllCardIds()).thenReturn(cardIds);
        when(cardStore.getCard("test1")).thenReturn(card1);
        when(cardStore.getCard("test2")).thenReturn(card2);
        when(cardStore.getCard("test3")).thenReturn(card3);
        Assert.assertEquals(2, cardSearchService.getCardsCreatedAfterGivenTimeStamp(5).size());
    }

    @Test
    public void testCardHighlightedForAUser() {

        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();

        card1.setId("test1");
        card2.setId("test2");
        card3.setId("test3");

        card1.setLastUpdatedTimeInMillis(4);
        card2.setLastUpdatedTimeInMillis(8);
        card3.setLastUpdatedTimeInMillis(9);

        Set<String> cardIds = new HashSet<>();
        cardIds.add("test1");
        cardIds.add("test2");
        cardIds.add("test3");

        User user1 = new User();
        user1.setId("user1");
        user1.setLastVisitedTimeInMillis(6);

        User user2 = new User();
        user1.setId("user2");
        user1.setLastVisitedTimeInMillis(6);

        card1.setUser(user1);
        card2.setUser(user1);
        card3.setUser(user2);


        when(CardStore.getInstance()).thenReturn(cardStore);
        when(cardStore.getAllCardIds()).thenReturn(cardIds);
        when(cardStore.getCard("test1")).thenReturn(card1);
        when(cardStore.getCard("test2")).thenReturn(card2);
        when(cardStore.getCard("test3")).thenReturn(card3);
        Assert.assertEquals(1, cardSearchService.getCardsHighlightedForAUser(user1).size());
    }

}
