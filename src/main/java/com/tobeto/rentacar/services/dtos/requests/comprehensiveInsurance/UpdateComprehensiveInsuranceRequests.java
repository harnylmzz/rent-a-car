package com.tobeto.rentacar.services.dtos.requests.comprehensiveInsurance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateComprehensiveInsuranceRequests {

    private int id;
    private int deductibleAmount;

}
