package kr.co.kim3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.kim3.service.AdminService;
import kr.co.kim3.transaction.vo.TransactionVO;



@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/transactions")
    public String getAllTransactions(Model model) {
        List<TransactionVO> transactions = adminService.getAllTransactions();
        model.addAttribute("transactions", transactions);
        return "adminTransactions";
    }
}
