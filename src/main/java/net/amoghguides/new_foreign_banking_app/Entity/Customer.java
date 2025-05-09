package net.amoghguides.new_foreign_banking_app.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name_of_customer",nullable = false)
    private String name;

    @Column (name="email_customer",nullable = false,unique = true)
    private String email;


    //ONE CUSTOMER CAN HAVE MANY ACCOUNT
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Account> accounts;
}
