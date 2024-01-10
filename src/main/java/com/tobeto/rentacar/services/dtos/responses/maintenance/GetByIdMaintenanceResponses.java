package com.tobeto.rentacar.services.dtos.responses.maintenance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdMaintenanceResponses {

    private int id;

    private String detail;

    private LocalDate date;
}
