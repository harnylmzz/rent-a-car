package com.tobeto.rentacar.entities.concretes;


import com.tobeto.rentacar.entities.concretes.enums.role.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a comprehensive insurance record in the Rent a Car system.
 * Each comprehensive insurance record has a unique identifier, a deductible amount,
 * and is associated with an insurance record.
 *
 * It extends the base Insurance class.
 *
 * @author [Harun Yılmaz]
 */

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comprehensive_insurances")
public class ComprehensiveInsurance extends Insurance {

    @Column(name = "deductible_amount")
    private int deductibleAmount;
}
