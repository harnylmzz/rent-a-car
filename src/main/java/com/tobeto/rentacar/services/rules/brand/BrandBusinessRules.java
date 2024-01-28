package com.tobeto.rentacar.services.rules.brand;

import com.tobeto.rentacar.core.exceptions.BusinessException;
import com.tobeto.rentacar.repository.BrandRepository;
import com.tobeto.rentacar.services.messages.brand.BrandMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {

    private final BrandRepository brandRepository;

    public void checkIfName(String name) {
        if (this.brandRepository.existsByName(name)) {
            throw new BusinessException(BrandMessages.BRAND_ALREADY_EXISTS);
        }
    }
}
