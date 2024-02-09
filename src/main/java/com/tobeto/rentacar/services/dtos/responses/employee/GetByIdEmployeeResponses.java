package com.tobeto.rentacar.services.dtos.responses.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdEmployeeResponses implements Serializable {

    private String firstName;

    private String lastName;

    private double salary;
}
