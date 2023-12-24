package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerBusinessRules {

    private CustomerRepository customerRepository;

    public void checkIfCustomerExists(String nationalityId) {
        if (this.customerRepository.existsByNationalityId(nationalityId)) {
            throw new RuntimeException("Customer already exists.");
        }
    }
}
