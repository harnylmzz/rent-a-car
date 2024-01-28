package com.tobeto.rentacar.services.rules.insurance;

import com.tobeto.rentacar.repository.InsuranceRepository;
import com.tobeto.rentacar.services.messages.insurance.InsuranceMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InsuranceBusinessRules {

    private final InsuranceRepository insuranceRepository;

    public void checkIfPolicyNumber(String policyNumber) {
        if (this.insuranceRepository.existsByPolicyNumber(policyNumber)) {
            throw new RuntimeException(InsuranceMessages.POLICY_NUMBER_ALREADY_EXISTS);
        }
    }
}
