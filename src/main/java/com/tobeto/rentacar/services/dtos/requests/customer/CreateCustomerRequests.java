package com.tobeto.rentacar.services.dtos.requests.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequests {

    @NotNull(message = "Nationality ID is mandatory")
    @NotBlank(message = "Nationality ID is mandatory")
    private String nationalityId;

    private String firstName;

    private String lastName;

    private String email;

    private String gsm;
}
