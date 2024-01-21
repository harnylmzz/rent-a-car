package com.tobeto.rentacar.services.dtos.requests.corporateCustomer;

import com.tobeto.rentacar.entities.concretes.enums.CustomerType;
import com.tobeto.rentacar.entities.concretes.enums.EmployeeType;
import com.tobeto.rentacar.entities.concretes.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCorporateCustomerRequests {

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    @NotNull(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone number is required")
    @NotNull(message = "Phone number is required")
    private String gsm;

    @NotBlank(message = "Username is required")
    @NotNull(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    @NotNull(message = "Password is required")
    @Size(min = 8, message = "Password should be at least 8 characters")
    private String password;

    @NotBlank(message = "Customer number is required")
    @NotNull(message = "Customer number is required")
    private String customerNumber;

    @NotBlank(message = "Company name is required")
    @NotNull(message = "Company name is required")
    private String companyName;

    @NotBlank(message = "Tax number is required")
    @NotNull(message = "Tax number is required")
    private String taxNumber;

    private Set<Role> authorities = Set.of(Role.ROLE_CUSTOMER);

    private CustomerType customerType = CustomerType.ROLE_CORPORATE;

}
