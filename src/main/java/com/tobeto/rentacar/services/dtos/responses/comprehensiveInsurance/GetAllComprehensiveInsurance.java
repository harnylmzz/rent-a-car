package com.tobeto.rentacar.services.dtos.responses.comprehensiveInsurance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllComprehensiveInsurance {

    private int id;
    private int deductibleAmount;
}
