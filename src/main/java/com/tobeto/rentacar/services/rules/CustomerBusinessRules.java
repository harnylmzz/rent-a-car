package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.core.exceptions.BusinessException;
import com.tobeto.rentacar.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerBusinessRules {

    private CustomerRepository customerRepository;

    public void checkIfCustomerNumber(String customerNumber) {
        if (this.customerRepository.checkIfCustomerNumberExists(customerNumber)) {
            throw new BusinessException("Customer number already exists");
        }
    }

}
