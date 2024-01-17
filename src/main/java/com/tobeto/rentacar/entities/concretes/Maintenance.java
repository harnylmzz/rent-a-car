package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * This class represents a maintenance record in the Rent a Car system.
 * Each maintenance record has a unique identifier, details about the maintenance,
 * the date when the maintenance was performed, and is associated with a specific car.
 *
 * It extends the base BaseEntity class.
 * @author [Harun Yılmaz]
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "maintenances")
public class Maintenance extends BaseEntity {

    @Column(name = "detail")
    private String detail;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
}
