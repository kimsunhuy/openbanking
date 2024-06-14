package kr.co.kim3.dao;

import kr.co.kim3.board.vo.BoardVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAOImpl implements BoardDAO {

    private final SqlSession sqlSession;

    @Autowired
    public BoardDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void insertBoard(BoardVO board) {
        sqlSession.insert("kr.co.kim3.dao.BoardDAO.insertBoard", board);
    }

    @Override
    public List<BoardVO> selectBoardByType(String bType) {
        return sqlSession.selectList("kr.co.kim3.dao.BoardDAO.selectBoardByType", bType);
    }

    @Override
    public void deleteBoard(int bNumber) {
        sqlSession.delete("kr.co.kim3.dao.BoardDAO.deleteBoard", bNumber);
    }
}
