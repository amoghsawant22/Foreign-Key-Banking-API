package net.amoghguides.new_foreign_banking_app.Controller;

import net.amoghguides.new_foreign_banking_app.Entity.Transaction;
import net.amoghguides.new_foreign_banking_app.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    //CREATE A NEW TRANSACTION
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    //GET A TRANSACTION BY ID
    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    //GET ALL TRANSACTIONS
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransaction();
    }

    //DELETE A TRANSACTION BY ID
    @DeleteMapping ("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }
}
