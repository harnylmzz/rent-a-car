package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * This class represents a car in the Rent a Car system.
 * Each car has a unique identifier, gear type, kilometer, manufacturing year,
 * price, plate number, and is associated with various related entities.
 *
 * It extends the base BaseEntity class.
 *
 * @author [Harun Yılmaz]
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car extends BaseEntity {

    @Column(name = "gear_type")
    private String gearType;

    @Column(name = "kilometer")
    private int kilometer;

    @Column(name = "year")
    private int year;

    @Column(name = "price")
    private double price;

    @Column(name = "plate")
    private String plate;

    @Column(name = "description")
    private String description;

    @Column(name ="amount_of_fuel")
    private String amountOfFuel;

    @Column(name = "number_of_seats")
    private int numberOfSeats;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id")
    private Color color;

    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;

    @OneToMany(mappedBy = "car")
    private List<Maintenance> maintenances;

    @OneToOne(mappedBy = "car")
    private Reservation reservation;

    @OneToOne(mappedBy = "car")
    private Insurance insurance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fuel_types_id", referencedColumnName="id")
    private FuelType fuelType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id" , referencedColumnName ="id")
    private Brand brand;

    @OneToMany(mappedBy = "car")
    private List<Image> images;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id", referencedColumnName="id")
    private Category category;
}
