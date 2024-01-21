package com.tobeto.rentacar.services.dtos.responses.trafficInsurance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdTrafficInsuranceResponses {

    private int id;

    private int deductibleAmount;
}
