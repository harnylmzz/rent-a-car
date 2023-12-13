package com.tobeto.rentacar.services.dtos.requests.employee;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequests {

    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name is mandatory")
    private double salary;
}
