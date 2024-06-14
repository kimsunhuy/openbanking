package kr.co.kim3.service;

import kr.co.kim3.board.vo.BoardVO;
import kr.co.kim3.dao.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardDAO boardDAO;

    @Autowired
    public BoardService(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    public void createBoard(BoardVO board) {
        boardDAO.insertBoard(board);
    }

    public List<BoardVO> getBoardByType(String bType) {
        return boardDAO.selectBoardByType(bType);
    }

    public void deleteBoard(int bNumber) {
        boardDAO.deleteBoard(bNumber);
    }
}
