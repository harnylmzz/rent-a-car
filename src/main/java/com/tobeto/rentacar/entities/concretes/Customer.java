package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.entities.concretes.enums.role.CustomerType;
import com.tobeto.rentacar.entities.concretes.enums.role.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "customer")
    private List<Rental> rentals;

    Set<Role> authorities = Set.of(Role.ROLE_CUSTOMER);

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_type")
    private CustomerType customerType;

}