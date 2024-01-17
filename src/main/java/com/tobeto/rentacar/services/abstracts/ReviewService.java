package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.dtos.requests.review.CreateReviewRequests;
import com.tobeto.rentacar.services.dtos.requests.review.DeleteReviewRequests;
import com.tobeto.rentacar.services.dtos.requests.review.UpdateReviewRequests;
import com.tobeto.rentacar.services.dtos.responses.review.GetAllReviewResponses;
import com.tobeto.rentacar.services.dtos.responses.review.GetByIdReviewResponses;


import java.util.List;

/**
 * Service interface for managing review-related operations.
 * Defines methods for retrieving, adding, updating, and deleting reviews.
 * Uses Data Transfer Objects (DTOs) for requests and responses.
 * Provides both individual and list-based retrieval of review information.
 * Supports CRUD (Create, Read, Update, Delete) operations for reviews.
 *
 * @author [Harun Yılmaz]
 */

public interface ReviewService {
    DataResult<List<GetAllReviewResponses>> getAll();

    DataResult<GetByIdReviewResponses> getById(int id);

    Result add(CreateReviewRequests createReviewRequests);

    Result update(UpdateReviewRequests updateUserRequests);

    Result delete(DeleteReviewRequests deleteUserRequests);
}
