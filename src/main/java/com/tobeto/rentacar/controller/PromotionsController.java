package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.PromotionService;
import com.tobeto.rentacar.services.dtos.requests.promotion.CreatePromotionRequests;
import com.tobeto.rentacar.services.dtos.requests.promotion.DeletePromotionRequests;
import com.tobeto.rentacar.services.dtos.requests.promotion.UpdatePromotionRequests;
import com.tobeto.rentacar.services.dtos.responses.promotion.GetAllPromotionResponses;
import com.tobeto.rentacar.services.dtos.responses.promotion.GetByIdPromotionResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/promotions")
@RequiredArgsConstructor
public class PromotionsController {

    private final PromotionService promotionService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllPromotionResponses>> getAll() {
        return this.promotionService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdPromotionResponses> getById(int id) {
        return this.promotionService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreatePromotionRequests createPromotionRequests) {
        return this.promotionService.add(createPromotionRequests);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdatePromotionRequests updatePromotionRequests) {
        return this.promotionService.update(updatePromotionRequests);
    }

    @DeleteMapping("/delete")
    public Result delete(DeletePromotionRequests deletePromotionRequests) {
        return this.promotionService.delete(deletePromotionRequests);
    }
}
