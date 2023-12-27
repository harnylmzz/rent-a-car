package com.tobeto.rentacar.services.dtos.requests.image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateImageRequests {

    private int id;
    private String url;
}
