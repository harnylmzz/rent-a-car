package com.tobeto.rentacar.services.dtos.requests.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelRequests {

    private int id;

    private String name;
}
