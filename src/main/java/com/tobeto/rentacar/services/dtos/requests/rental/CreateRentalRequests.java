package com.tobeto.rentacar.services.dtos.requests.rental;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequests {

    @NotNull(message = "Start date is mandatory")
    private LocalDate startDate;

    @NotNull(message = "End date is mandatory")
    private LocalDate endDate;

    private LocalDate returnDate;

    @NotNull(message = "Start kilometer is mandatory")
    private int startKilometer;

    private int endKilometer;

    @NotNull(message = "Total price is mandatory")
    private double totalPrice;

    @NotNull(message = "Discount is mandatory")
    private double discount;
}
