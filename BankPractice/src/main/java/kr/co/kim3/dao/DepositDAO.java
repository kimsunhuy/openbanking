package kr.co.kim3.dao;

import kr.co.kim3.deposit.vo.DepositVO;
import java.util.List;

public interface DepositDAO {
    void insertDeposit(DepositVO deposit);
    List<DepositVO> selectAllDeposits();
    List<DepositVO> selectAllProducts(); // 추가된 메소드
}
