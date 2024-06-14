package kr.co.kim3.service;

import kr.co.kim3.transaction.vo.TransactionVO;
import kr.co.kim3.dao.TransactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final TransactionDAO transactionDAO;

    @Autowired
    public AdminService(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    public List<TransactionVO> getAllTransactions() {
        return transactionDAO.selectAllTransactions();
    }
}
