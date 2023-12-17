package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.core.exceptions.BusinessException;
import com.tobeto.rentacar.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelBusinessRules {

    private ModelRepository modelRepository;

    public void checkIfName(String name) {
        if (this.modelRepository.existsByName(name)) {
            throw new BusinessException("Model name already exists");
        }
    }
}
