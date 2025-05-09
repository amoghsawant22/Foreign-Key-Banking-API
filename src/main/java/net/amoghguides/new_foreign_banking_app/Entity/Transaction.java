package net.amoghguides.new_foreign_banking_app.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double amount;

    @Column (name = "type")
    private String type; //eg. Deposit/Withdraw

    //MANY TRANSACTIONS CAN BE ASSOCIATED WITH ONE ACCOUNT
    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonBackReference
    private Account account;
}
