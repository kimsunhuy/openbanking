package kr.co.kim3.dao;

import kr.co.kim3.client.vo.ClientVO;

public interface ClientDAO {
    void insertClient(ClientVO client);
    ClientVO selectClientById(String cId);
    void deleteClient(String cId);
    void updateLoginAttempts(ClientVO client);
	ClientVO selectClientByPhoneNum(String cPhone_num);
	ClientVO selectClientByEmail(String cEmail);
	boolean checkClientIdExists(String cId);
}
