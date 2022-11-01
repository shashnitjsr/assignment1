package store;

import enitites.Board;
import enitites.Label;

import java.util.HashMap;
import java.util.Map;

public class BoardStore {
    Map<String, Board> boardMap = new HashMap<>();
    private static BoardStore boardStore = new BoardStore();

    private BoardStore() {

    }

    public static BoardStore getInstance() {
        return boardStore;
    }

    public void addLabel(Board board) {
        boardMap.put(board.getId(), board);
    }

    public Board getBoard(String id) {
        return boardMap.get(id);
    }
}
