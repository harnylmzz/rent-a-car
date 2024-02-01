package com.tobeto.rentacar.services.dtos.requests.color;

import com.tobeto.rentacar.services.constans.color.ColorMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateColorRequests {

    @NotNull(message = ColorMessages.NAME_IS_MANDATORY)
    @NotBlank(message = ColorMessages.NAME_IS_MANDATORY)
    @Size(min = 2, max = 20, message = ColorMessages.COLOR_NAME_MUST_BE_BETWEEN_2_AND_2O_CHARACTERS)
    private String name;

}
