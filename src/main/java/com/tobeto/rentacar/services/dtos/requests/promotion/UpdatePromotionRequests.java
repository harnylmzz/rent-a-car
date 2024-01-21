package com.tobeto.rentacar.services.dtos.requests.promotion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePromotionRequests {

    private int id;

    private String code;

    private String discount;

    private String type;

    private String description;
}
