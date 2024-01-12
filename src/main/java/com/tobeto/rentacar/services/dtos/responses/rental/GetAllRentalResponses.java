package com.tobeto.rentacar.services.dtos.responses.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class    GetAllRentalResponses {

    private int id;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate returnDate;

    private int startKilometer;

    private int endKilometer;

    private double totalPrice;

    private double discount;

    private int carId;

    private int employeeId;

    private int customerId;

    public GetAllRentalResponses(LocalDate startDate) {

    }

    public GetAllRentalResponses(int startKilometer) {

    }

    public GetAllRentalResponses(double totalPrice) {

    }
}
