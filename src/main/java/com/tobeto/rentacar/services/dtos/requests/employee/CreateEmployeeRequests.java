package com.tobeto.rentacar.services.dtos.requests.employee;

import com.tobeto.rentacar.services.constans.employee.EmployeeMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequests {

    @NotNull(message = EmployeeMessages.NAME_IS_MANDATORY)
    @NotBlank(message = EmployeeMessages.NAME_IS_MANDATORY)
    private double salary;

    private String firstName;

    private String lastName;

    private String email;

    private String gsm;}
