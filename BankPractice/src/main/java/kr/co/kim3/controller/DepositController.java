package kr.co.kim3.controller;

import kr.co.kim3.service.DepositService;
import kr.co.kim3.deposit.vo.DepositVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/deposits")
public class DepositController {

    private final DepositService depositService;

    @Autowired
    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<DepositVO> products = depositService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }
}
