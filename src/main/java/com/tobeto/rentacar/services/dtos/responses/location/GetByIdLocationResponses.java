package com.tobeto.rentacar.services.dtos.responses.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdLocationResponses {

    private int id;

    private String countryCode;

    private String city;

    private String district;

    private String address;
}
