package boardservice;

import enitites.Board;
import enitites.Card;
import enitites.Column;
import enitites.Label;
import enitites.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import java.util.Map;


public class BoardServiceTest {

    private BoardService boardService = new BoardServiceImpl();

    @Test
    public void testBoardServiceOutput() {
        Label label1 = new Label("test1", "label1");

        Card card1 = new Card();


        Map<String, Label> labelMap1 = new HashMap<>();
        labelMap1.put("test1", label1);


        card1.setLabelMap(labelMap1);
        card1.setId("card1");

        User user = new User();
        user.setId("user1");
        card1.setUser(user);

        Map<String, Card> cardMap = new HashMap<>();
        cardMap.put("card1", card1);

        Column column = new Column();
        column.setId("column1");
        column.setCardMap(cardMap);

        Map<String, Column> columnMap = new HashMap<>();
        columnMap.put("column1", column);

        Board board = new Board();
        board.setId("board1");
        board.setColumnMap(columnMap);
        Assert.assertEquals("{\"id\":\"board1\",\"columnMap\":{\"column1\":{\"id\":\"column1\",\"cardMap\":{\"card1\":{\"id\":\"card1\",\"labelMap\":{\"test1\":{\"id\":\"test1\",\"label\":\"label1\"}},\"createdTimeInMillis\":0,\"lastUpdatedTimeInMillis\":0,\"user\":{\"id\":\"user1\",\"lastVisitedTimeInMillis\":0}}}}}}",
                boardService.getBoardAsJsonString(board));
    }
}
