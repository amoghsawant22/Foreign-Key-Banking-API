package net.amoghguides.new_foreign_banking_app.Repositories;

import net.amoghguides.new_foreign_banking_app.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository  extends JpaRepository<Transaction,Long> {
}
