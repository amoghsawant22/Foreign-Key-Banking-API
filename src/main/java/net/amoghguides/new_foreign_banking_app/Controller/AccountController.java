package net.amoghguides.new_foreign_banking_app.Controller;

import net.amoghguides.new_foreign_banking_app.Entity.Account;
import net.amoghguides.new_foreign_banking_app.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;


    //CREATE A NEW ACCOUNT
    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    //GET ACCOUNT BY ID
    @GetMapping("/{id}")
    public  Account getAccountById( @PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    //GET ACCOUNT ALL ACCOUNTS
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAcounts();
    }

    //DELETE ACCOUNT BY ID
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }



}
