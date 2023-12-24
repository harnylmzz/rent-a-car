package com.tobeto.rentacar.services.dtos.requests.rental;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequests {

    @NotNull(message = "Start date is mandatory")
    private LocalDate startDate;

    @NotNull(message = "End date is mandatory")
    private LocalDate endDate;

    @Nullable
    private LocalDate returnDate = null;

    @NotNull(message = "Start kilometer is mandatory")
    private int startKilometer;

    @Nullable
    private Integer endKilometer = null;

    @NotNull(message = "Total price is mandatory")
    private double totalPrice;

    @NotNull(message = "Discount is mandatory")
    private double discount;

    private int carId;

    private int customerId;

    private int employeeId;

}