package com.tobeto.rentacar.services.dtos.requests.model;

import com.tobeto.rentacar.services.constans.model.ModelMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequests {

    @NotNull(message = ModelMessages.NAME_IS_MANDATORY)
    @NotBlank(message = ModelMessages.NAME_IS_MANDATORY)
    @Size(min = 2, max = 20, message = ModelMessages.NAME_MUST_BE_BETWEEN_2_AND_20_CHARACTERS)
    private String name;

    private int brandId;

}
