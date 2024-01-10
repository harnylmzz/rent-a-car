package com.tobeto.rentacar.services.dtos.requests.maintenance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMaintenanceRequests {

    private int id;

    private String detail;

    private LocalDate date;
}
