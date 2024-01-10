package com.tobeto.rentacar.services.dtos.responses.fuelType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdFuelTypeResponses {

    private int id;

    private String type;

}
