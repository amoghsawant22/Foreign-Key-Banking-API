package net.amoghguides.new_foreign_banking_app.Services.implementation;

import net.amoghguides.new_foreign_banking_app.Entity.Account;
import net.amoghguides.new_foreign_banking_app.Repositories.AccountRepository;
import net.amoghguides.new_foreign_banking_app.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImplementation  implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        return account.orElse(null);
    }

    @Override
    public List<Account> getAllAcounts() {
        return accountRepository.findAll();
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
