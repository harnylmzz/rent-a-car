package com.tobeto.rentacar.services.dtos.requests.car;

import com.tobeto.rentacar.services.constans.car.CarMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequests {

    @NotNull(message = CarMessages.BRAND_ID_IS_REQUIRED)
    private int kilometer;

    @NotNull(message = CarMessages.YEAR_IS_REQUIRED)
    private int year;

    @NotNull(message = CarMessages.PRICE_IS_REQUIRED)
    private double price;

    private String gearType;

    @Pattern(regexp = "^[0-9]{2}\\s[A-Z]{1,3}\\s[0-9]{2,3}$", message = CarMessages.PLEASE_ENTER_A_VALID_TURKISH_PLATE_NUMBER)
    @NotNull(message = CarMessages.PLATE_IS_REQUIRED)
    @NotBlank(message = CarMessages.PLATE_IS_REQUIRED)
    private String plate;

    private String amountOfFuel;

    private String description;

    private int numberOfSeats;

    private boolean isAvailable;

    private int modelId;

    private int colorId;

    private int fuelTypeId;

    private int categoryId;

    private int brandId;



}
