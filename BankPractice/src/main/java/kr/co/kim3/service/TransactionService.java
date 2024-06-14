package kr.co.kim3.service;

import kr.co.kim3.transaction.vo.TransactionVO;

import java.util.List;

public interface TransactionService {
    void transfer(String fromAccountNumber, String toAccountNumber, double amount);
    List<TransactionVO> getTransactionsByAccount(String accountNumber);
    List<TransactionVO> getAllTransactions();
    void scheduleTransfer(TransactionVO transaction);
}
