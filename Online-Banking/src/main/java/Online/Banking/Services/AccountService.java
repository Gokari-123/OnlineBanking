package Online.Banking.Services;


import Online.Banking.Entity.Account;
import Online.Banking.Entity.User;
import Online.Banking.Repository.AccountRepository;
import Online.Banking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    public Account createAccount(Long userId) {
        // Retrieve the User entity using userId
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        // Create a new Account and set the User
        Account account = new Account();
        account.setUser(user);
        account.setBalance(BigDecimal.ZERO);

        // Save the account to the database
        return accountRepository.save(account);
    }


    public BigDecimal getBalance(Long userId) {
        Account account = accountRepository.findByUserId(userId);
        if (account == null) {
            throw new RuntimeException("Account not found for user ID: " + userId);
        }
        return account.getBalance();
    }

    public void deposit(Long userId, BigDecimal amount) {
        Account account = accountRepository.findByUserId(userId);
        account.setBalance(account.getBalance().add(amount));
        accountRepository.save(account);
    }

    public void transfer(Long fromUserId, Long toUserId, BigDecimal amount) {
        Account fromAccount = accountRepository.findByUserId(fromUserId);
        Account toAccount = accountRepository.findByUserId(toUserId);

        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }

}