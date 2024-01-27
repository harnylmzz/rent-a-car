package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.core.exceptions.BusinessException;
import com.tobeto.rentacar.repository.CorporateCustomerRepository;
import com.tobeto.rentacar.services.messages.corporateCustomer.CorporateCustomerMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CorporateCustomerBusinessRules {

    private final CorporateCustomerRepository corporateCustomerRepository;

    public void checkIfTaxNumber(String taxNumber) {
        if (this.corporateCustomerRepository.existsByTaxNumber(taxNumber)) {
            throw new BusinessException(CorporateCustomerMessages.TAX_NUMBER_ALREADY_EXISTS);
        }
    }

    public void checkIfCompanyName(String companyName) {
        if (this.corporateCustomerRepository.existsByCompanyName(companyName)) {
            throw new BusinessException(CorporateCustomerMessages.COMPANY_NAME_ALREADY_EXISTS);
        }
    }
}
