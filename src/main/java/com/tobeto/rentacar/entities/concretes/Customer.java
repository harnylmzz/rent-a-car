package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.entities.concretes.enums.role.CustomerType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * This class represents a customer in the Rent a Car system.
 * Each customer has a unique identifier, a nationality ID, and is associated with a user account.
 * <p>
 * It extends the base User class.
 *
 * @author [Harun Yılmaz]
 */

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer extends User {

    @Column(name = "customer_number")
    private String customerNumber;

    @OneToMany(mappedBy = "customer")
    private List<Rental> rentals;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_type")
   private CustomerType customerType;

}
