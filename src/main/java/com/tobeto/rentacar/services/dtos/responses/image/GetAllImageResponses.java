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

    private String publicId;

    private int width;

    private int height;

    private String format;

    private int bytes;

    private int carId;
}
