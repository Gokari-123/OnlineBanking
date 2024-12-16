package Online.Banking.Controller;


import Online.Banking.Entity.Account;
import Online.Banking.Repository.AccountRepository;
import Online.Banking.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/create")
    public String createAccount(@RequestParam Long userId) {
        accountService.createAccount(userId);
        return "Account created successfully.";
    }

    @GetMapping("/balance")
    public BigDecimal getBalance(@RequestParam Long userId) {
        return accountService.getBalance(userId);
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam Long userId, @RequestParam BigDecimal amount) {
        accountService.deposit(userId, amount);
        return "Deposit successful.";
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam Long fromUserId, @RequestParam Long toUserId, @RequestParam BigDecimal amount) {
        accountService.transfer(fromUserId, toUserId, amount);
        return "Transfer successful.";
    }
}
