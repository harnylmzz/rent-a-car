package com.tobeto.rentacar.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

/**
 * This class represents a corporate customer in the Rent a Car system.
 * Each corporate customer has a unique identifier, a company name, and a tax number.
 *
 * It extends the base Customer class.
 *
 * @author [Harun Yılmaz]
 */

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "corporate_customers")
public class CorporateCustomer extends Customer {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "tax_number")
    private String taxNumber;

}
