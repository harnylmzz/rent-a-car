package com.tobeto.rentacar.services.concretes;


import com.tobeto.rentacar.config.modelmapper.ModelMapperManager;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.Review;
import com.tobeto.rentacar.repository.ReviewRepository;
import com.tobeto.rentacar.services.abstracts.ReviewService;
import com.tobeto.rentacar.services.dtos.requests.review.CreateReviewRequests;
import com.tobeto.rentacar.services.dtos.requests.review.DeleteReviewRequests;
import com.tobeto.rentacar.services.dtos.requests.review.UpdateReviewRequests;
import com.tobeto.rentacar.services.dtos.responses.review.GetAllReviewResponses;
import com.tobeto.rentacar.services.dtos.responses.review.GetByIdReviewResponses;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewManager  implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ModelMapperManager modelMapperService;

    @Override
    public DataResult<List<GetAllReviewResponses>> getAll() {
        List<Review> reviews = reviewRepository.findAll();
        List<GetAllReviewResponses> getAllReviewResponses = reviews.stream()
                .map(review -> this.modelMapperService.forResponse()
                        .map(review, GetAllReviewResponses.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllReviewResponses, true, "Review listed");
    }
    @Override
    public DataResult<GetByIdReviewResponses> getById(int id){
        Review review = reviewRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Data not found."));
        GetByIdReviewResponses getByIdReviewResponses = this.modelMapperService.forResponse()
                .map(review, GetByIdReviewResponses.class);
        return new DataResult<>(getByIdReviewResponses, true,"Review listed");
    }

    @Override
    public Result add(CreateReviewRequests createReviewRequests){
        Review review = this.modelMapperService.forRequest()
                .map(createReviewRequests, Review.class);
        this.reviewRepository.save(review);

        return new SuccessResult("Review added");

    }
    @Override
    public Result update(UpdateReviewRequests updateReviewRequests){
        Review review = this.modelMapperService.forRequest()
                .map(updateReviewRequests, Review.class);
        review.setId(updateReviewRequests.getId());
        review.setRating(updateReviewRequests.getRating());
        review.setComment(updateReviewRequests.getComment());
        this.reviewRepository.save(review);

        return new SuccessResult("Review update");
    }

    public Result delete(DeleteReviewRequests deleteReviewRequests) {
        Review review = this.modelMapperService.forRequest()
                .map(deleteReviewRequests, Review.class);
        this.reviewRepository.delete(review);

        return new SuccessResult("Review deleted");
    }
















}
