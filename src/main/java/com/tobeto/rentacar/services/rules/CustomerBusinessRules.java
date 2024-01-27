package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.core.exceptions.BusinessException;
import com.tobeto.rentacar.repository.CustomerRepository;
import com.tobeto.rentacar.services.messages.customer.CustomerMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerBusinessRules {

    private CustomerRepository customerRepository;

    public void checkIfCustomerNumber(String customerNumber) {
        if (this.customerRepository.checkIfCustomerNumberExists(customerNumber)) {
            throw new BusinessException(CustomerMessages.CUSTOMER_NUMBER_ALREADY_EXISTS);
        }
    }

}
