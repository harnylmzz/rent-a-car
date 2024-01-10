package com.tobeto.rentacar.services.dtos.responses.corporateCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCorporateCustomer {

    private int id;

    private String companyName;

    private String taxNumber;
}
