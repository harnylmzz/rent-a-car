package com.tobeto.rentacar.services.dtos.responses.corporateCustomer;

import com.tobeto.rentacar.entities.concretes.enums.role.CustomerType;
import com.tobeto.rentacar.entities.concretes.enums.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCorporateCustomer implements Serializable {

    private int id;

    private String email;

    private String gsm;

    private String username;

    private String password;

    private String companyName;

    private String taxNumber;

    private Set<Role> authorities = Set.of(Role.ROLE_CUSTOMER);

    private CustomerType customerType = CustomerType.ROLE_CORPORATE;
}
