package com.tobeto.rentacar.services.dtos.responses.review;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllReviewResponses {
    private int id;
    private String comment;

    private int rating;
}
