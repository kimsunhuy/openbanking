package kr.co.kim3.service;

import kr.co.kim3.dao.DepositDAO;
import kr.co.kim3.deposit.vo.DepositVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepositService {

    private final DepositDAO depositDAO;

    @Autowired
    public DepositService(DepositDAO depositDAO) {
        this.depositDAO = depositDAO;
    }

    public void insertDeposit(DepositVO deposit) {
        depositDAO.insertDeposit(deposit);
    }

    public List<DepositVO> getAllDeposits() {
        return depositDAO.selectAllDeposits();
    }

    public List<DepositVO> getAllProducts() {
        return depositDAO.selectAllProducts();
    }
}
