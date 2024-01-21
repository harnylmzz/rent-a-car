package com.tobeto.rentacar.services.dtos.responses.promotion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPromotionResponses {

    private int id;

    private String code;

    private String discount;

    private String type;

    private String description;
}
