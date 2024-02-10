package com.tobeto.rentacar.services.dtos.responses.fuelType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdFuelTypeResponses implements Serializable {

    private int id;

    private String type;

}
