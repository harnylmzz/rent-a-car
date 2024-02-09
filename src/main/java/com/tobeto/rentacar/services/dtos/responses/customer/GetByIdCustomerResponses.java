package com.tobeto.rentacar.services.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCustomerResponses implements Serializable {

    private String customerNumber;

}
