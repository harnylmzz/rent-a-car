package com.tobeto.rentacar.services.dtos.requests.brand;

import com.tobeto.rentacar.services.constans.brand.BrandMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequests {

    @NotNull(message = BrandMessages.NAME_IS_MANDATORY)
    @NotBlank(message = BrandMessages.NAME_IS_MANDATORY)
    @Size(min = 2, max = 20, message = BrandMessages.NAME_MUST_BE_BETWEEN_2_AND_20_CHARACTERS)
    private String name;

}
