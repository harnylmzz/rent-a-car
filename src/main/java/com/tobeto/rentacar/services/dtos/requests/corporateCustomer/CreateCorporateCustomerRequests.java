package com.tobeto.rentacar.services.dtos.requests.corporateCustomer;

import com.tobeto.rentacar.entities.concretes.enums.role.CustomerType;
import com.tobeto.rentacar.entities.concretes.enums.role.Role;
import com.tobeto.rentacar.services.constans.corporateCustomer.CorporateCustomerMessages;
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

    @Email(message = CorporateCustomerMessages.EMAIL_SHOULD_BE_VALID)
    @NotBlank(message = CorporateCustomerMessages.EMAIL_IS_REQUIRED)
    @NotNull(message = CorporateCustomerMessages.EMAIL_IS_REQUIRED)
    private String email;

    @NotBlank(message = CorporateCustomerMessages.PHONE_NUMBER_IS_REQUIRED)
    @NotNull(message = CorporateCustomerMessages.PHONE_NUMBER_IS_REQUIRED)
    private String gsm;

    @NotBlank(message = CorporateCustomerMessages.USERNAME_IS_REQUIRED)
    @NotNull(message = CorporateCustomerMessages.USERNAME_IS_REQUIRED)
    private String username;

    @NotBlank(message = CorporateCustomerMessages.PASSWORD_IS_REQUIRED)
    @NotNull(message = CorporateCustomerMessages.PASSWORD_IS_REQUIRED)
    @Size(min = 8, message = CorporateCustomerMessages.PASSWORD_SHOULD_BE_AT_LEAST_8_CHARACTERS)
    private String password;

    @NotBlank(message = CorporateCustomerMessages.CUSTOMER_NUMBER_IS_REQUIRED)
    @NotNull(message = CorporateCustomerMessages.CUSTOMER_NUMBER_IS_REQUIRED)
    private String customerNumber;

    @NotBlank(message = CorporateCustomerMessages.COMPANY_NAME_IS_REQUIRED)
    @NotNull(message = CorporateCustomerMessages.COMPANY_NAME_IS_REQUIRED)
    private String companyName;

    @NotBlank(message = CorporateCustomerMessages.TAX_NUMBER_IS_REQUIRED)
    @NotNull(message = CorporateCustomerMessages.TAX_NUMBER_IS_REQUIRED)
    private String taxNumber;

    private Set<Role> authorities = Set.of(Role.ROLE_CUSTOMER);

    private CustomerType customerType = CustomerType.ROLE_CORPORATE;

}
