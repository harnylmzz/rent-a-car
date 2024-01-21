package com.tobeto.rentacar.services.dtos.requests.corporateCustomer;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCorporateCustomerRequests {

    @NotBlank(message = "Company name is required")
    @NotNull(message = "Company name is required")
    private String companyName;

    @NotBlank(message = "Tax number is required")
    @NotNull(message = "Tax number is required")
    private String taxNumber;
}
