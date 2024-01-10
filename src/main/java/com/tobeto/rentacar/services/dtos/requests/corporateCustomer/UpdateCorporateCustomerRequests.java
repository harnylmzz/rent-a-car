package com.tobeto.rentacar.services.dtos.requests.corporateCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCorporateCustomerRequests {

    private int id;

    private String companyName;

    private String taxNumber;
}
