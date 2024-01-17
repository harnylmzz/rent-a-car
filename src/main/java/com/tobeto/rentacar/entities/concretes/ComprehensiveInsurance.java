package com.tobeto.rentacar.entities.concretes;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

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
