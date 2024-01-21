package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.dtos.requests.promotion.CreatePromotionRequests;
import com.tobeto.rentacar.services.dtos.requests.promotion.DeletePromotionRequests;
import com.tobeto.rentacar.services.dtos.requests.promotion.UpdatePromotionRequests;
import com.tobeto.rentacar.services.dtos.responses.promotion.GetAllPromotionResponses;
import com.tobeto.rentacar.services.dtos.responses.promotion.GetByIdPromotionResponses;

import java.util.List;

public interface PromotionService {

    DataResult<List<GetAllPromotionResponses>> getAll();

    DataResult<GetByIdPromotionResponses> getById(int id);

    Result add(CreatePromotionRequests createPromotionRequests);

    Result update(UpdatePromotionRequests updatePromotionRequests);

    Result delete(DeletePromotionRequests deletePromotionRequests);
}
