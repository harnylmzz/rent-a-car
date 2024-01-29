package com.tobeto.rentacar.services.rules.promotion;

import com.tobeto.rentacar.core.exceptions.BusinessException;
import com.tobeto.rentacar.repository.PromotionRepository;
import com.tobeto.rentacar.services.constans.promotion.PromotionMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PromotionBusinessRules {

    private final PromotionRepository promotionRepository;

    public void checkIfPromotionCode(String code) {
        if (this.promotionRepository.existsByPromotionCode(code)) {
            throw new BusinessException(PromotionMessages.PROMOTION_CODE_ALREADY_EXISTS);
        }
    }
}