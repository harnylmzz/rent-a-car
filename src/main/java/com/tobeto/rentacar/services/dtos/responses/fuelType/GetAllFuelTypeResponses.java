package com.tobeto.rentacar.services.dtos.responses.fuelType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllFuelTypeResponses {

    private int id;

    private String type;

}