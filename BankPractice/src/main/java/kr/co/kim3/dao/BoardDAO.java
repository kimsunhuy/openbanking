package kr.co.kim3.dao;

import java.util.List;

import kr.co.kim3.board.vo.BoardVO;

public interface BoardDAO {
    void insertBoard(BoardVO board);
    List<BoardVO> selectBoardByType(String bType);
	void deleteBoard(int bNumber);
}
