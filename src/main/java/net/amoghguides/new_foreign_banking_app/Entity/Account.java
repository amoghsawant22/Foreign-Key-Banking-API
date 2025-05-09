package net.amoghguides.new_foreign_banking_app.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;



@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Accounts")
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Account_Holder_Name")
    private String accountHolderName;

    @Column(name="avl_Balance",nullable = false)
    private double balance;


    // MANY ACCOUNTS BELONG TO ONE CUSTOMER
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonBackReference
    private Customer customer;

    // ONE ACCOUNT HAS MANY TRANSACTIONS
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Transaction> transactions;
}
