package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import com.tobeto.rentacar.entities.concretes.Car;
import com.tobeto.rentacar.entities.concretes.Customer;
import com.tobeto.rentacar.entities.concretes.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rentals")
public class Rental extends BaseEntity {

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "start_kilometer")
    private int startKilometer;

    @Column(name = "end_kilometer")
    private Integer endKilometer;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "discount")
    private double discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
