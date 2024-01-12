package com.tobeto.rentacar.services.dtos.responses.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdRentalResponses {

    private int id;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate returnDate;
}
