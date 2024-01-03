package com.tobeto.rentacar.services.dtos.responses.image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllImageResponses {

    private int id;

    private String url;

    private int carId;

    public GetAllImageResponses(String url) {

    }
}
