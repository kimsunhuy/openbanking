package kr.co.kim3.dao;

import kr.co.kim3.dao.DepositDAO;
import kr.co.kim3.deposit.vo.DepositVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DepositDAOImpl implements DepositDAO {

    private final SqlSessionTemplate sqlSession;

    @Autowired
    public DepositDAOImpl(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void insertDeposit(DepositVO deposit) {
        sqlSession.insert("DepositDAO.insertDeposit", deposit);
    }

    @Override
    public List<DepositVO> selectAllDeposits() {
        return sqlSession.selectList("DepositDAO.selectAllDeposits");
    }

    @Override
    public List<DepositVO> selectAllProducts() { // 추가된 메소드
        return sqlSession.selectList("DepositDAO.selectAllProducts");
    }
}
