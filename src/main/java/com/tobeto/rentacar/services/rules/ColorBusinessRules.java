package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.core.exceptions.BusinessException;
import com.tobeto.rentacar.repository.ColorRepository;
import com.tobeto.rentacar.services.messages.color.ColorMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ColorBusinessRules {

    private ColorRepository colorRepository;

    public void checkIfName(String name) {
        if (this.colorRepository.existsByName(name)) {
            throw new BusinessException(ColorMessages.COLOR_ALREADY_EXISTS);
        }
    }
}
