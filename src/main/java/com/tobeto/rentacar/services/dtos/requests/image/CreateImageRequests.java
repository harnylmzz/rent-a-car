package com.tobeto.rentacar.services.dtos.requests.image;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateImageRequests {

    @NotNull(message = "url is required")
    @NotBlank(message = "url is required")
    private String url;

    private int carId;
}
