package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.dtos.requests.review.CreateReviewRequests;
import com.tobeto.rentacar.services.dtos.requests.review.DeleteReviewRequests;
import com.tobeto.rentacar.services.dtos.requests.review.UpdateReviewRequests;
import com.tobeto.rentacar.services.dtos.responses.review.GetAllReviewResponses;
import com.tobeto.rentacar.services.dtos.responses.review.GetByIdReviewResponses;


import java.util.List;

public interface ReviewService {
    DataResult<List<GetAllReviewResponses>> getAll();

    DataResult<GetByIdReviewResponses> getById(int id);

    Result add(CreateReviewRequests createReviewRequests);

    Result update(UpdateReviewRequests updateUserRequests);

    Result delete(DeleteReviewRequests deleteUserRequests);
}
