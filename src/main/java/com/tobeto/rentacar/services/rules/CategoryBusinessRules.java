package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.core.exceptions.BusinessException;
import com.tobeto.rentacar.repository.CategoryRepository;
import com.tobeto.rentacar.services.messages.category.CategoryMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryBusinessRules {

    private final CategoryRepository categoryRepository;

    public void checkIfName(String name) {
        if (this.categoryRepository.existsByName(name)) {
            throw new BusinessException(CategoryMessages.CATEGORY_ALREADY_EXISTS);
        }
    }
}
