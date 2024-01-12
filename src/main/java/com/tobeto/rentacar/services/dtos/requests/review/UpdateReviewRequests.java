package com.tobeto.rentacar.services.dtos.requests.review;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReviewRequests {

    private int id;
    private String comment;

    private int rating;
}
