package com.tobeto.rentacar.services.dtos.responses.individualCustomer;

import com.tobeto.rentacar.entities.concretes.enums.CustomerType;
import com.tobeto.rentacar.entities.concretes.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllIndividualCustomerResponses {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String gsm;

    private String username;

    private String password;

    private String customerNumber;

    private Set<Role> authorities = Set.of(Role.ROLE_CUSTOMER);

    private CustomerType customerType = CustomerType.ROLE_INDIVIDUAL;
}
