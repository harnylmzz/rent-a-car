package com.tobeto.rentacar.services.dtos.requests.individualCustomer;

import com.tobeto.rentacar.entities.concretes.enums.role.CustomerType;
import com.tobeto.rentacar.entities.concretes.enums.role.Role;
import com.tobeto.rentacar.services.constans.individualCustomer.IndividualCustomerMessages;
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
public class CreateIndividualCustomerRequests {

    @NotNull(message = IndividualCustomerMessages.NATINOLITY_ID_IS_REQUIRED)
    @NotBlank(message = IndividualCustomerMessages.NATINOLITY_ID_IS_REQUIRED)
    private String nationalityId;

    @NotNull(message = IndividualCustomerMessages.FIRST_NAME_IS_REQUIRED)
    @NotBlank(message = IndividualCustomerMessages.FIRST_NAME_IS_REQUIRED)
    private String firstName;

    @NotNull(message = IndividualCustomerMessages.LAST_NAME_IS_REQUIRED)
    @NotBlank(message = IndividualCustomerMessages.LAST_NAME_IS_REQUIRED)
    private String lastName;

    @Email(message = IndividualCustomerMessages.EMAIL_SHOULD_BE_VALID)
    @NotBlank(message = IndividualCustomerMessages.EMAIL_IS_REQUIRED)
    @NotNull(message = IndividualCustomerMessages.EMAIL_IS_REQUIRED)
    private String email;

    @NotBlank(message = IndividualCustomerMessages.PHONE_NUMBER_IS_REQUIRED)
    @NotNull(message = IndividualCustomerMessages.PHONE_NUMBER_IS_REQUIRED)
    private String gsm;

    @NotBlank(message = IndividualCustomerMessages.USERNAME_IS_REQUIRED)
    @NotNull(message = IndividualCustomerMessages.USERNAME_IS_REQUIRED)
    private String username;

    @NotBlank(message = IndividualCustomerMessages.PASSWORD_IS_REQUIRED)
    @NotNull(message = IndividualCustomerMessages.PASSWORD_IS_REQUIRED)
    @Size(min = 8, message = IndividualCustomerMessages.PASSWORD_SHOULD_BE_AT_LEAST_8_CHARACTERS)
    private String password;

    @NotBlank(message = IndividualCustomerMessages.CUSTOMER_NUMBER_IS_REQUIRED)
    @NotNull(message = IndividualCustomerMessages.CUSTOMER_NUMBER_IS_REQUIRED)
    private String customerNumber;

    private Set<Role> authorities = Set.of(Role.ROLE_CUSTOMER);

    private CustomerType customerType = CustomerType.ROLE_INDIVIDUAL;
}
