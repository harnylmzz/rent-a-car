package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.Promotion;
import com.tobeto.rentacar.repository.PromotionRepository;
import com.tobeto.rentacar.services.abstracts.PromotionService;
import com.tobeto.rentacar.services.dtos.requests.promotion.CreatePromotionRequests;
import com.tobeto.rentacar.services.dtos.requests.promotion.DeletePromotionRequests;
import com.tobeto.rentacar.services.dtos.requests.promotion.UpdatePromotionRequests;
import com.tobeto.rentacar.services.dtos.responses.promotion.GetAllPromotionResponses;
import com.tobeto.rentacar.services.dtos.responses.promotion.GetByIdPromotionResponses;
import com.tobeto.rentacar.services.constans.promotion.PromotionMessages;
import com.tobeto.rentacar.services.rules.promotion.PromotionBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotionManager implements PromotionService {

    private final PromotionRepository promotionRepository;
    private final ModelMapperService modelMapperService;
    private final PromotionBusinessRules promotionBusinessRules;

    @Override
    public DataResult<List<GetAllPromotionResponses>> getAll() {

        List<Promotion> promotions = promotionRepository.findAll();
        List<GetAllPromotionResponses> getAllPromotionResponses = promotions.stream()
                .map(promotion -> this.modelMapperService.forResponse()
                        .map(promotion, GetAllPromotionResponses.class))
                .collect(java.util.stream.Collectors.toList());

        return new DataResult<>(getAllPromotionResponses, true, PromotionMessages.PROMOTIONS_LISTED);
    }

    @Override
    public DataResult<GetByIdPromotionResponses> getById(int id) {

        Promotion promotion = promotionRepository.findById(id).orElseThrow(() -> new DataNotFoundException(PromotionMessages.PROMOTION_NOT_FOUND));

        GetByIdPromotionResponses getByIdPromotionResponses = this.modelMapperService.forResponse()
                .map(promotion, GetByIdPromotionResponses.class);
        return new DataResult<>(getByIdPromotionResponses, true, PromotionMessages.PROMOTIONS_LISTED);
    }

    @Override
    public Result add(CreatePromotionRequests createPromotionRequests) {

        this.promotionBusinessRules.checkIfPromotionCode(createPromotionRequests.getCode());

        Promotion promotion = this.modelMapperService.forRequest()
                .map(createPromotionRequests, Promotion.class);

        this.promotionRepository.save(promotion);

        return new SuccessResult(PromotionMessages.PROMOTION_ADDED);
    }

    @Override
    public Result update(UpdatePromotionRequests updatePromotionRequests) {

        Promotion promotion = this.modelMapperService.forRequest()
                .map(updatePromotionRequests, Promotion.class);

        promotion.setId(updatePromotionRequests.getId());
        promotion.setDiscount(updatePromotionRequests.getDiscount());
        promotion.setCode(updatePromotionRequests.getCode());
        promotion.setType(updatePromotionRequests.getType());

        return new SuccessResult(PromotionMessages.PROMOTION_UPDATED);
    }

    @Override
    public Result delete(DeletePromotionRequests deletePromotionRequests) {

        Promotion promotion = this.modelMapperService.forRequest()
                .map(deletePromotionRequests, Promotion.class);

        this.promotionRepository.delete(promotion);

        return new SuccessResult(PromotionMessages.PROMOTION_DELETED);
    }
}
