package com.tobeto.rentacar.services.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarResponses {

    private int id;

    private double price;

    private String plate;

    private int kilometer;

    private int year;

    private int modelId;

    private int colorId;

}
