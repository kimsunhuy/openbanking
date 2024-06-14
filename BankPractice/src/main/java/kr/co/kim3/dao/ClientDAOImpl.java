package kr.co.kim3.dao;

import kr.co.kim3.client.vo.ClientVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDAOImpl implements ClientDAO {

    private final SqlSession sqlSession;

    @Autowired
    public ClientDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public boolean checkClientIdExists(String cId) {
        int count = sqlSession.selectOne("kr.co.kim3.dao.ClientDAO.checkClientIdExists", cId);
        return count > 0;
    }
    
    @Override
    public void insertClient(ClientVO client) {
        sqlSession.insert("kr.co.kim3.dao.ClientDAO.insertClient", client);
    }

    @Override
    public ClientVO selectClientById(String cId) {
        return sqlSession.selectOne("kr.co.kim3.dao.ClientDAO.selectClientById", cId);
    }

    @Override
    public ClientVO selectClientByPhoneNum(String cPhone_num) {
        return sqlSession.selectOne("kr.co.kim3.dao.ClientDAO.selectClientByPhoneNum", cPhone_num);
    }

    @Override
    public ClientVO selectClientByEmail(String cEmail) {
        return sqlSession.selectOne("kr.co.kim3.dao.ClientDAO.selectClientByEmail", cEmail);
    }

    @Override
    public void deleteClient(String cId) {
        sqlSession.update("kr.co.kim3.dao.ClientDAO.deleteClient", cId);
    }

    @Override
    public void updateLoginAttempts(ClientVO client) {
        sqlSession.update("kr.co.kim3.dao.ClientDAO.updateLoginAttempts", client);
    }
}
