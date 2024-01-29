package com.tobeto.rentacar.services.dtos.requests.car;

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

    private String gearType;

    private double price;

    private String plate;

    private String description;

    private String amount_of_fuel;

    private int number_of_seats;


}
