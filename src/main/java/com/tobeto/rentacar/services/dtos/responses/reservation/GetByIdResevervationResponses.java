package com.tobeto.rentacar.services.dtos.responses.reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdResevervationResponses {

    private int id;

    private LocalDate startDate;

    private LocalDate endDate;

    private String additionalServices;
}
