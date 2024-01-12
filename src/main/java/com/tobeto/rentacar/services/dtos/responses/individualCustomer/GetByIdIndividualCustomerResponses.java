package com.tobeto.rentacar.services.dtos.responses.individualCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdIndividualCustomerResponses {

    private int id;

    private String firstName;

    private String lastName;
}
