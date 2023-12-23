package com.tobeto.rentacar.services.dtos.responses.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployeeResponses {

    private String firstName;

    private String lastName;

    private double salary;

}
