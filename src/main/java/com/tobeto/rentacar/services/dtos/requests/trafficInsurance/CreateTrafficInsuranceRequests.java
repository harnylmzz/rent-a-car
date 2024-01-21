package com.tobeto.rentacar.services.dtos.requests.trafficInsurance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTrafficInsuranceRequests {

    private int deductibleAmount;
}
