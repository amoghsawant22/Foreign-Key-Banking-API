package net.amoghguides.new_foreign_banking_app.Repositories;


import net.amoghguides.new_foreign_banking_app.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
