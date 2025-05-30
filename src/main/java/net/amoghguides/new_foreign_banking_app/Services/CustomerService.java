package net.amoghguides.new_foreign_banking_app.Services;

import net.amoghguides.new_foreign_banking_app.Entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {
    Customer creatCustomer(Customer customer);
    Customer getCustomerById(Long id);
    List <Customer> getAllCustomer();
    void deleteCustomer (Long id);

}
