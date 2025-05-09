package net.amoghguides.new_foreign_banking_app.Services;

import net.amoghguides.new_foreign_banking_app.Entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer creatCustomer(Customer customer);
    Customer getCustomerById(Long id);
    List <Customer> getAllCustomer();
    void deleteCustomer (Long id);

}
