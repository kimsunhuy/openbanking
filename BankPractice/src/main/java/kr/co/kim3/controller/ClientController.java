package kr.co.kim3.controller;

import kr.co.kim3.client.vo.ClientVO;
import kr.co.kim3.service.ClientService;
import kr.co.kim3.service.SmsService;
import net.nurigo.sdk.message.exception.NurigoEmptyResponseException;
import net.nurigo.sdk.message.exception.NurigoUnknownException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/clients")
public class ClientController {

	@Autowired
    private ClientService clientService;
    private final SmsService smsService;
    private final Map<String, String> verificationCodes = new HashMap<>();

    @Autowired
    public ClientController(ClientService clientService, SmsService smsService) {
        this.clientService = clientService;
        this.smsService = smsService;
    }

    @PostMapping("/login")
    public String login(ClientVO client, Model model, HttpSession session) {
        ClientVO loginVO = clientService.login(client.getcId(), client.getcPassword());
        if (loginVO != null) {
            session.setAttribute("client", loginVO);
            return "redirect:/home";
        } else {
            model.addAttribute("errorMessage", "Invalid ID or password.");
            return "login";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    
    @ModelAttribute("client")
    public ClientVO getClientModel() {
        return new ClientVO();
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("client", new ClientVO());
        return "register";
    }

    @GetMapping("/checkId")
    @ResponseBody
    public boolean checkClientIdExists(@RequestParam String cId) {
        return clientService.checkClientIdExists(cId);
    }
    
    @PostMapping("/register")
    public String registerClient(@ModelAttribute("client") ClientVO client, Model model) {
    	System.out.println("hi");
        clientService.registerClient(client); // ClientService를 사용해 등록 처리
        System.out.println("hi2");
        model.addAttribute("message", "Client registered successfully!");
        return "redirect:/";
    }

    @PostMapping("/sendVerificationCode")
    public ResponseEntity<String> sendVerificationCode(@RequestParam String phoneNumber) throws NurigoEmptyResponseException, NurigoUnknownException {
        String verificationCode = generateVerificationCode();
        smsService.sendVerificationCode(phoneNumber, verificationCode);
        verificationCodes.put(phoneNumber, verificationCode);
        return ResponseEntity.ok("Verification code sent.");
    }

    private String generateVerificationCode() {
        Random random = new Random();
        int code = 1000 + random.nextInt(9000);
        return String.valueOf(code);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientVO> getClient(@PathVariable String id) {
        return clientService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable String id) {
        clientService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted.");
    }
}
