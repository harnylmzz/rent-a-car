package com.tobeto.rentacar.services.dtos.requests.rental;

import com.tobeto.rentacar.services.constans.rental.RentalMessages;
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
@NotNull(message = RentalMessages.START_DATE_IS_MANDATORY)
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = RentalMessages.END_DATE_IS_MANDATORY)
    private LocalDate endDate;

    @Nullable
    private LocalDate returnDate = null;

    @NotNull(message = RentalMessages.START_KILOMETER_IS_MANDATORY)
    private int startKilometer;

    @Nullable
    private Integer endKilometer = null;

    @NotNull(message = RentalMessages.TOTAL_PRICE_IS_MANDATORY)
    private Double totalPrice;

    @Min(value = 0, message = RentalMessages.DISCOUNT_MUST_BE_GREATER_THAN_0)
    @NotNull(message = RentalMessages.DISCOUNT_IS_MANDATORY)
    private double discount;

    private int carId;

    private int customerId;

    private int employeeId;

}