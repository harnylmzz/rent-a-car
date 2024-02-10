package com.tobeto.rentacar.services.dtos.responses.insurance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdInsuranceResponses implements Serializable {

    private int id;

    private String policyNumber;

    private LocalDate startDate;

    private LocalDate endDate;

    private String details;
}
