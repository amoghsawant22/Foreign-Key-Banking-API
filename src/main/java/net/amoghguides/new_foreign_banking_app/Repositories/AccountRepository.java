package net.amoghguides.new_foreign_banking_app.Repositories;

import net.amoghguides.new_foreign_banking_app.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
