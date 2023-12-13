package com.tobeto.rentacar.services.dtos.requests.car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequests {

    @NotNull(message = "Brand id is required")
    @NotBlank(message = "Brand id is required")
    private int kilometer;

    @NotNull(message = "Year is required")
    @NotBlank(message = "Year is required")
    private int year;

    @NotNull(message = "Price is required")
    @NotBlank(message = "Price is required")
    private double price;

    @NotNull(message = "Plate is required")
    @NotBlank(message = "Plate is required")
    private String plate;
}
