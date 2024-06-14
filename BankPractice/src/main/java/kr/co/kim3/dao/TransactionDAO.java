package kr.co.kim3.dao;

import kr.co.kim3.transaction.vo.TransactionVO;

import java.util.List;

public interface TransactionDAO {
    void insertTransaction(TransactionVO transaction);
    List<TransactionVO> selectTransactionsByAccountNumber(String tAccount_number);
    List<TransactionVO> selectAllTransactions();
    void insertScheduledTransaction(TransactionVO transaction);
}
