package net.amoghguides.new_foreign_banking_app.Services;

import net.amoghguides.new_foreign_banking_app.Entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    Account createAccount(Account account);

    Account getAccountById(Long id);

    List<Account> getAllAcounts();

    void deleteAccount(Long id);

}
