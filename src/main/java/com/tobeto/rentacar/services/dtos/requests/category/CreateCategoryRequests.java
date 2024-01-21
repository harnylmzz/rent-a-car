package com.tobeto.rentacar.services.dtos.requests.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCategoryRequests {

    @NotNull(message = "Category name is required")
    @NotBlank(message = "Category name is required")
    private String name;
}
