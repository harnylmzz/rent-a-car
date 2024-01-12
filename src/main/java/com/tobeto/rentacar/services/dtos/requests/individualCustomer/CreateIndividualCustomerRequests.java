package com.tobeto.rentacar.services.dtos.requests.individualCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateIndividualCustomerRequests {


    private String firstName;

    private String lastName;
}
