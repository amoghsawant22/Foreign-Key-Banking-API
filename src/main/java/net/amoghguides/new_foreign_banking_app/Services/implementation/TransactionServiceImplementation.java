package net.amoghguides.new_foreign_banking_app.Services.implementation;

import net.amoghguides.new_foreign_banking_app.Entity.Account;
import net.amoghguides.new_foreign_banking_app.Entity.Transaction;
import net.amoghguides.new_foreign_banking_app.Repositories.AccountRepository;
import net.amoghguides.new_foreign_banking_app.Repositories.TransactionRepository;
import net.amoghguides.new_foreign_banking_app.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImplementation implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        Account account = transaction.getAccount();

        if (account == null || account.getId() == null) {
            throw new IllegalArgumentException("Transaction must be linked to a valid account.");
        }

        Account existingAccount = accountRepository.findById(account.getId())
                .orElseThrow(() -> new IllegalArgumentException("Account not found."));

        double amount = transaction.getAmount();
        String type = transaction.getType();

        if ("Deposit".equalsIgnoreCase(type)) {
            existingAccount.setBalance(existingAccount.getBalance() + amount);
        } else if ("Withdraw".equalsIgnoreCase(type)) {
            if (existingAccount.getBalance() < amount) {
                throw new IllegalArgumentException("Insufficient balance for withdrawal.");
            }
            existingAccount.setBalance(existingAccount.getBalance() - amount);
        } else {
            throw new IllegalArgumentException("Invalid transaction type. Use 'Deposit' or 'Withdraw'.");
        }

        accountRepository.save(existingAccount);
        transaction.setAccount(existingAccount);

        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Transaction with give id not found : "+id));
    }

    @Override
    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
