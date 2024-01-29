package com.tobeto.rentacar.services.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCarResponses {

    private int id;

    private double price;

    private String plate;

    private String gearType;

    private int kilometer;

    private int year;

    private String modelName;

    private String colorName;

    private String fuelType;
    private String categoryName;

    private int brand_id;

    private String amount_of_fuel ;

    private int number_of_seats;


    private String description;

}
