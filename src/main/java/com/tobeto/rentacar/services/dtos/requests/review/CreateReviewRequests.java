package com.tobeto.rentacar.services.dtos.requests.review;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateReviewRequests {
    private String comment;

    private int rating;

}
