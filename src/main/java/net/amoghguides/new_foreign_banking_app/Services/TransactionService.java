package net.amoghguides.new_foreign_banking_app.Services;

import net.amoghguides.new_foreign_banking_app.Entity.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction createTransaction(Transaction transaction);

    Transaction getTransactionById(Long id);

    List<Transaction> getAllTransaction();

    void deleteTransaction(Long id);
}
