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
public class UpdateCarRequests {

    private int id;

    private int kilometer;

    private int year;

    private double price;

    private String gearType;

    private String plate;

    private String description;

    private int numberOfSeats;

    private boolean isAvailable;

    private int modelId;

    private int colorId;

    private int fuelTypeId;

    private int categoryId;

    private int brandId;

}
