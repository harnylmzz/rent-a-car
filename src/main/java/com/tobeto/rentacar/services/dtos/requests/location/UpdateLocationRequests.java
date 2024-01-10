package com.tobeto.rentacar.services.dtos.requests.location;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLocationRequests {

    private int id;

    private String countryCode;

    @Column(name="city")
    private String city;

    @Column(name="district")
    private String district;

    @Column(name="address")
    private String address;
}
