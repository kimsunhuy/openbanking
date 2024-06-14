package kr.co.kim3.service;

import kr.co.kim3.client.vo.ClientVO;
import kr.co.kim3.dao.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientDAO clientDAO;

    private static final List<String> RESERVED_KEYWORDS = Arrays.asList("관리자", "admin");
    private static final int MAX_LOGIN_ATTEMPTS = 5;

    @Autowired
    public ClientService(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public boolean isClientIdTaken(String clientId) {
        return clientDAO.selectClientById(clientId) != null;
    }

    public boolean containsReservedKeyword(String clientId) {
        return RESERVED_KEYWORDS.stream().anyMatch(clientId::contains);
    }

    public void registerClient(ClientVO client) {
        if (isClientIdTaken(client.getcId())) {
            throw new IllegalArgumentException("ID is already taken.");
        }
        if (containsReservedKeyword(client.getcId())) {
            throw new IllegalArgumentException("ID contains reserved keyword.");
        }
        if (!isValidPassword(client.getcPassword())) {
            throw new IllegalArgumentException("Password does not meet requirements.");
        }
       // client.setcPassword(encodePassword(client.getcPassword()));
        clientDAO.insertClient(client);
    }

    private boolean isValidPassword(String password) {
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{9,}$";
        return password.matches(regex);
    }

    private String encodePassword(String password) {
        // Implement password encoding logic (e.g., using BCrypt)
        return password;
    }

    public Optional<ClientVO> findByPhoneNumber(String phoneNum) {
        return Optional.ofNullable(clientDAO.selectClientByPhoneNum(phoneNum));
    }

    public Optional<ClientVO> findByEmail(String email) {
        return Optional.ofNullable(clientDAO.selectClientByEmail(email));
    }

    public Optional<ClientVO> findById(String cId) {
        return Optional.ofNullable(clientDAO.selectClientById(cId));
    }

    public ClientVO login(String cId, String password) {
        ClientVO client = clientDAO.selectClientById(cId);
        if (client != null) {
            if (client.getLoginAttempts() >= MAX_LOGIN_ATTEMPTS) {
                throw new IllegalArgumentException("Account is locked due to too many failed login attempts.");
            }
            if (client.getcPassword().equals(password)) {
                client.setLoginAttempts(0);
                clientDAO.updateLoginAttempts(client);
                return client;
            } else {
                client.setLoginAttempts(client.getLoginAttempts() + 1);
                clientDAO.updateLoginAttempts(client);
                return null;
            }
        } else {
            throw new IllegalArgumentException("Invalid ID or password.");
        }
    }

    public void deleteAccount(String cId) {
        clientDAO.deleteClient(cId);
    }
    
    
    public boolean checkClientIdExists(String cId) {
        return clientDAO.checkClientIdExists(cId);
    }
    
}
