package net.amoghguides.new_foreign_banking_app.Controller;

import net.amoghguides.new_foreign_banking_app.Entity.Customer;
import net.amoghguides.new_foreign_banking_app.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //CREATE A NEW CUSTOMER
    @PostMapping
    public Customer creteCustomer(@RequestBody Customer customer) {
        return customerService.creatCustomer(customer);
    }

    //GET CUSTOMER BY ID
    @GetMapping("/{id}")
    public Customer getCustomerById( @PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    //GET ALL CUSTOMER
    @GetMapping
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    //DELETE CUSTOMER BY ID
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
