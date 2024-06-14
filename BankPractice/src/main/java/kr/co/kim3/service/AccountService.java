package kr.co.kim3.service;

import kr.co.kim3.account.vo.AccountVO;
import kr.co.kim3.client.vo.ClientVO;
import kr.co.kim3.dao.AccountDAO;
import kr.co.kim3.dao.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountDAO accountDAO;
    private final ClientDAO clientDAO;

    @Autowired
    public AccountService(AccountDAO accountDAO, ClientDAO clientDAO) {
        this.accountDAO = accountDAO;
        this.clientDAO = clientDAO;
    }

    public AccountVO createAccount(String clientId, AccountVO account) {
        ClientVO client = clientDAO.selectClientById(clientId);
        if (client != null) {
            account.setAcClient_id(clientId);
            accountDAO.insertAccount(account);
            return account;
        }
        return null;
    }

    public List<AccountVO> getAccountsByClient(String clientId) {
        return accountDAO.selectAccountsByClientId(clientId);
    }

    public boolean checkTransferLimits(AccountVO account, double amount) {
        double dailyTransferred = getDailyTransferredAmount(account);
        double monthlyTransferred = getMonthlyTransferredAmount(account);

        return dailyTransferred + amount <= account.getDailyTransferLimit() &&
                monthlyTransferred + amount <= account.getMonthlyTransferLimit();
    }

    private double getDailyTransferredAmount(AccountVO account) {
        // Implement logic to calculate daily transferred amount
        return 0.0;
    }

    private double getMonthlyTransferredAmount(AccountVO account) {
        // Implement logic to calculate monthly transferred amount
        return 0.0;
    }
}
