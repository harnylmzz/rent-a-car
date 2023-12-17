package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.core.exceptions.BusinessException;
import com.tobeto.rentacar.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {

    private BrandRepository brandRepository;

    public void checkIfName(String name) {
        if (this.brandRepository.existsByName(name)) {
            throw new BusinessException("Brand name already exists");
        }
    }
}
