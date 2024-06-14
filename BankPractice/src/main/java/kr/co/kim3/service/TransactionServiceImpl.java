package kr.co.kim3.service;

import kr.co.kim3.account.vo.AccountVO;
import kr.co.kim3.dao.AccountDAO;
import kr.co.kim3.dao.TransactionDAO;
import kr.co.kim3.service.AccountService;
import kr.co.kim3.service.TransactionService;
import kr.co.kim3.transaction.vo.TransactionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionDAO transactionDAO;
    private final AccountDAO accountDAO;
    private final AccountService accountService;

    @Autowired
    public TransactionServiceImpl(TransactionDAO transactionDAO, AccountDAO accountDAO, AccountService accountService) {
        this.transactionDAO = transactionDAO;
        this.accountDAO = accountDAO;
        this.accountService = accountService;
    }

    @Transactional
    @Override
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        AccountVO fromAccount = accountDAO.selectAccountByNumber(fromAccountNumber);
        AccountVO toAccount = accountDAO.selectAccountByNumber(toAccountNumber);

        if (fromAccount != null && toAccount != null) {
            if (!accountService.checkTransferLimits(fromAccount, amount)) {
                throw new IllegalArgumentException("Transfer limits exceeded.");
            }

            if (fromAccount.getAcBalance() >= amount) {
                fromAccount.setAcBalance(fromAccount.getAcBalance() - amount);
                toAccount.setAcBalance(toAccount.getAcBalance() + amount);

                accountDAO.updateAccountBalance(fromAccount);
                accountDAO.updateAccountBalance(toAccount);

                // Record transaction
                TransactionVO transaction = new TransactionVO();
                transaction.settAccount_number(fromAccountNumber);
                transaction.settName("Transfer to " + toAccountNumber);
                transaction.settAmount(-amount);
                transaction.settType(1); // Assuming 1 for transfer
                transactionDAO.insertTransaction(transaction);

                transaction = new TransactionVO();
                transaction.settAccount_number(toAccountNumber);
                transaction.settName("Transfer from " + fromAccountNumber);
                transaction.settAmount(amount);
                transaction.settType(1); // Assuming 1 for transfer
                transactionDAO.insertTransaction(transaction);
            }
        }
    }

    @Override
    public List<TransactionVO> getTransactionsByAccount(String accountNumber) {
        return transactionDAO.selectTransactionsByAccountNumber(accountNumber);
    }

    @Override
    public List<TransactionVO> getAllTransactions() {
        return transactionDAO.selectAllTransactions();
    }

    @Override
    public void scheduleTransfer(TransactionVO transaction) {
        transactionDAO.insertScheduledTransaction(transaction);
    }
}
