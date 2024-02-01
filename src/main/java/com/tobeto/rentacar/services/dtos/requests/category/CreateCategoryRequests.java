package com.tobeto.rentacar.services.dtos.requests.category;

import com.tobeto.rentacar.services.constans.category.CategoryMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCategoryRequests {

    @NotNull(message = CategoryMessages.CATEGORY_NAME_IS_REQUIRED)
    @NotBlank(message = CategoryMessages.CATEGORY_NAME_IS_REQUIRED)
    private String name;
}
