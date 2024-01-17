package com.tobeto.rentacar.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

/**
 * This class represents a type of insurance specifically for traffic coverage.
 * It extends the base Insurance class and includes additional information
 * such as the deductible amount.
 *
 *  It extends the base Insurance.
 *
 * @author [Harun Yılmaz]
 */

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "insurances")
public class TrafficInsurance extends Insurance {

    @Column(name = "deductible_amount")
    private int deductibleAmount;
}
