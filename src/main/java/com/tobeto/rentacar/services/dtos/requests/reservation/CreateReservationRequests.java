package com.tobeto.rentacar.services.dtos.requests.reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReservationRequests {

    private LocalDate startDate;

    private LocalDate endDate;

    private String additionalServices;

}
