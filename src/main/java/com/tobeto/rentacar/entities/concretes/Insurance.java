package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * This class represents an insurance record in the Rent a Car system.
 * Each insurance record has a unique identifier, a policy number, start and end dates,
 * additional details, and is associated with a specific car.
 * It extends the base BaseEntity class.
 *
 * @author [Harun Yılmaz]
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "insurances")
public class Insurance extends BaseEntity {

    @Column(name = "policy_number")
    private String policyNumber;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "details")
    private String details;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;
}
