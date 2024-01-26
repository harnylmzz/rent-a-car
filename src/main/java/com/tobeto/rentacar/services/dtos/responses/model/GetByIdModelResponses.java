package com.tobeto.rentacar.services.dtos.responses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdModelResponses {

    private int id;

    private String name;

    private int brandId;

}
