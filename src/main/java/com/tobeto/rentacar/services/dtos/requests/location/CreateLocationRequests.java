package com.tobeto.rentacar.services.dtos.requests.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLocationRequests {

    private String countryCode;

    private String city;

    private String district;

    private String address;
}
