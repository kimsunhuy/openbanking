package kr.co.kim3.dao;

import kr.co.kim3.account.vo.AccountVO;
import kr.co.kim3.dao.AccountDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private final SqlSession sqlSession;

    @Autowired
    public AccountDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void insertAccount(AccountVO account) {
        sqlSession.insert("kr.co.kim3.dao.AccountDAO.insertAccount", account);
    }

    @Override
    public List<AccountVO> selectAccountsByClientId(String acClient_id) {
        return sqlSession.selectList("kr.co.kim3.dao.AccountDAO.selectAccountsByClientId", acClient_id);
    }

    @Override
    public void updateAccountBalance(AccountVO account) {
        sqlSession.update("kr.co.kim3.dao.AccountDAO.updateAccountBalance", account);
    }

    @Override
    public AccountVO selectAccountByNumber(String acNumber) {
        return sqlSession.selectOne("kr.co.kim3.dao.AccountDAO.selectAccountByNumber", acNumber);
    }
}
