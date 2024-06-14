package kr.co.kim3.dao;

import kr.co.kim3.account.vo.AccountVO;

import java.util.List;

public interface AccountDAO {
    void insertAccount(AccountVO account);
    List<AccountVO> selectAccountsByClientId(String acClient_id);
    void updateAccountBalance(AccountVO account);
    AccountVO selectAccountByNumber(String acNumber); // 추가된 메서드
}
