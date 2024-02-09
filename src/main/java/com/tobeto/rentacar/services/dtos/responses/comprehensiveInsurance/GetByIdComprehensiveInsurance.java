package com.tobeto.rentacar.services.dtos.responses.comprehensiveInsurance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdComprehensiveInsurance implements Serializable {

    private int id;
    private int deductibleAmount;
}
