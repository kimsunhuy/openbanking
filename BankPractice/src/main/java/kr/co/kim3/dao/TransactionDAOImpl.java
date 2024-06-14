package kr.co.kim3.dao;

import kr.co.kim3.dao.TransactionDAO;
import kr.co.kim3.transaction.vo.TransactionVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

    private final SqlSession sqlSession;

    @Autowired
    public TransactionDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void insertTransaction(TransactionVO transaction) {
        sqlSession.insert("kr.co.kim3.dao.TransactionDAO.insertTransaction", transaction);
    }

    @Override
    public List<TransactionVO> selectTransactionsByAccountNumber(String tAccount_number) {
        return sqlSession.selectList("kr.co.kim3.dao.TransactionDAO.selectTransactionsByAccountNumber", tAccount_number);
    }

    @Override
    public List<TransactionVO> selectAllTransactions() {
        return sqlSession.selectList("kr.co.kim3.dao.TransactionDAO.selectAllTransactions");
    }

    @Override
    public void insertScheduledTransaction(TransactionVO transaction) {
        sqlSession.insert("kr.co.kim3.dao.TransactionDAO.insertScheduledTransaction", transaction);
    }
}
