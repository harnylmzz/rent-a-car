package com.tobeto.rentacar.services.dtos.requests.rental;

import jakarta.validation.constraints.NotBlank;
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

    @NotNull(message = "Return date is mandatory")
    private LocalDate returnDate;

    @NotNull(message = "Start kilometer is mandatory")
    @NotBlank(message = "Start kilometer is mandatory")
    private int startKilometer;

    @NotNull(message = "End kilometer is mandatory")
    @NotBlank(message = "End kilometer is mandatory")
    private int endKilometer;

    @NotNull(message = "Total price is mandatory")
    @NotBlank(message = "Total price is mandatory")
    private double totalPrice;

    @NotNull(message = "Discount is mandatory")
    @NotBlank(message = "Discount is mandatory")
    private double discount;

    private int carId;

    private int userId;

}
