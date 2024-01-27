package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.repository.ComprehensiveInsuranceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ComprehensiveInsuranceBusinessRules {

    private final ComprehensiveInsuranceRepository comprehensiveInsuranceRepository;
}
