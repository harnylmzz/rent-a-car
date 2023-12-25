package com.tobeto.rentacar.services.dtos.requests.rental;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequests {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Start date is mandatory")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "End date is mandatory")
    private LocalDate endDate;

    @Nullable
    private LocalDate returnDate = null;

    @NotNull(message = "Start kilometer is mandatory")
    private int startKilometer;

    @Nullable
    private Integer endKilometer = null;

    @NotNull(message = "Total price is mandatory")
    private Double totalPrice;

    @Min(value = 0, message = "Discount must be greater than 0")
    @NotNull(message = "Discount is mandatory")
    private double discount;

    private int carId;

    private int customerId;

    private int employeeId;

}