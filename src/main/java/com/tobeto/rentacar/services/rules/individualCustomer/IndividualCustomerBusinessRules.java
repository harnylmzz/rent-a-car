package com.tobeto.rentacar.services.rules.individualCustomer;

import com.tobeto.rentacar.repository.IndividualCustomerRepository;
import com.tobeto.rentacar.services.constans.individualCustomer.IndividualCustomerMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IndividualCustomerBusinessRules {

    private final IndividualCustomerRepository individualCustomerRepository;
    public void checkIfNationalityIdExists(String nationalityId) {
        if (this.individualCustomerRepository.existsByNationalityId(nationalityId))
            throw new RuntimeException(IndividualCustomerMessages.NATIONALITY_ID_ALREADY_EXISTS);
    }
}
