package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.ReviewService;
import com.tobeto.rentacar.services.dtos.requests.review.CreateReviewRequests;
import com.tobeto.rentacar.services.dtos.requests.review.DeleteReviewRequests;
import com.tobeto.rentacar.services.dtos.requests.review.UpdateReviewRequests;
import com.tobeto.rentacar.services.dtos.responses.review.GetAllReviewResponses;
import com.tobeto.rentacar.services.dtos.responses.review.GetByIdReviewResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/review")
@AllArgsConstructor
public class ReviewController {
    private ReviewService reviewService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllReviewResponses>> getAll(){
        return this.reviewService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdReviewResponses> getById(int id) {
        return reviewService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateReviewRequests createReviewRequests) {
        return this.reviewService.add(createReviewRequests);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateReviewRequests updateReviewlRequests) {
        return this.reviewService.update(updateReviewlRequests);
    }
    @DeleteMapping("/delete")
    public Result delete(DeleteReviewRequests deleteReviewRequests) {
        return this.reviewService.delete(deleteReviewRequests);
    }

}
