package columnservice;

import enitites.Card;
import enitites.Column;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import store.ColumnStore;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;


@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "store.*")
public class ColumnServiceTest {

    @Mock
    ColumnStore columnStore;

    @InjectMocks
    ColumnService columnService = new ColumnServiceImpl();

    @Before
    public void beforeAll() {
        mockStatic(ColumnStore.class);
    }

    @Test
    public void testCardSearchService() {
        Column column = new Column();
        column.setId("test1");
        Map<String, Card> cardMap = new HashMap<>();
        cardMap.put("test1", new Card());
        cardMap.put("test2", new Card());
        column.setCardMap(cardMap);
        when(ColumnStore.getInstance()).thenReturn(columnStore);
        when(columnStore.getColumn("test1")).thenReturn(column);
        Assert.assertEquals(2, columnService.displayCardsInColumn("test1").size());
    }

}
