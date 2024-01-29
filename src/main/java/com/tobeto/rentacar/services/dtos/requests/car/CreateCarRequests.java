package com.tobeto.rentacar.services.dtos.requests.car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequests {

    @NotNull(message = "Brand id is required")
    private int kilometer;

    @NotNull(message = "Year is required")
    private int year;

    @NotNull(message = "Price is required")
    private double price;

    private String gearType;

    @Pattern(regexp = "^[0-9]{2}\\s[A-Z]{1,3}\\s[0-9]{2,3}$", message = "Please enter a valid Turkish plate number")
    @NotNull(message = "Plate is required")
    @NotBlank(message = "Plate is required")
    private String plate;

    private int modelId;

    private int colorId;

    private int fuelTypeId;

    private int categoryId;

    private int brand_id;

    private String amount_of_fuel;

    private String description;

    private int number_of_seats;

}
