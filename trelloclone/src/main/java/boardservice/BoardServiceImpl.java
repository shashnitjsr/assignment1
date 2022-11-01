package boardservice;

import com.google.gson.Gson;
import enitites.Board;

public class BoardServiceImpl implements BoardService {


    @Override
    public String getBoardAsJsonString(Board board) {
       return new Gson().toJson(board);
    }
}
