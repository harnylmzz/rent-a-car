package com.tobeto.rentacar.services.dtos.requests.color;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateColorRequests {

    private int id;
    private String name;
}
