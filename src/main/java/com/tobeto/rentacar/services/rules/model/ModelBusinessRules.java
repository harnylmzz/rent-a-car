package com.tobeto.rentacar.services.rules.model;

import com.tobeto.rentacar.core.exceptions.BusinessException;
import com.tobeto.rentacar.repository.ModelRepository;
import com.tobeto.rentacar.services.constans.model.ModelMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelBusinessRules {

    private ModelRepository modelRepository;

    public void checkIfName(String name) {
        if (this.modelRepository.existsByName(name)) {
            throw new BusinessException(ModelMessages.MODEL_NAME_ALREADY_EXIST);
        }
    }
}
