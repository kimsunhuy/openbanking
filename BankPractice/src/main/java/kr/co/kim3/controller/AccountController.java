package kr.co.kim3.controller;

import kr.co.kim3.account.vo.AccountVO;
import kr.co.kim3.client.vo.ClientVO;
import kr.co.kim3.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping("/create")
    public String createAccount() {
    	return "createAccount";
    }
    
    @PostMapping("/create")
    public String createAccount(@ModelAttribute AccountVO account, @RequestParam String clientId, Model model) {
        AccountVO createdAccount = accountService.createAccount(clientId, account);
        model.addAttribute("account", createdAccount);
        return "accountDetails";
    }

    @GetMapping("/{clientId}")
    public String getAccountsByClient(@PathVariable String clientId, Model model) {
        List<AccountVO> accounts = accountService.getAccountsByClient(clientId);
        model.addAttribute("accounts", accounts);
        return "accountList";
    }
}
