package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.CategoryService;
import com.tobeto.rentacar.services.dtos.requests.category.CreateCategoryRequests;
import com.tobeto.rentacar.services.dtos.requests.category.DeleteCategoryRequests;
import com.tobeto.rentacar.services.dtos.requests.category.UpdateCategoryRequests;
import com.tobeto.rentacar.services.dtos.responses.category.GetAllCategoryResponse;
import com.tobeto.rentacar.services.dtos.responses.category.GetByIdCategoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing category-related endpoints in the Rent a Car system.
 * Provides endpoints for retrieving, adding, updating, and deleting categories.
 * Utilizes the CategoryService for category-related operations.
 * Supports validation for request bodies.
 *
 * @author [Harun Yılmaz]
 */

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesController {
    private final CategoryService categoryService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllCategoryResponse>> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdCategoryResponse> getById(int id) {
        return categoryService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateCategoryRequests createCategoryResponse) {
        return categoryService.add(createCategoryResponse);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateCategoryRequests updateCategoryResponse) {
        return categoryService.update(updateCategoryResponse);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteCategoryRequests deleteCategoryResponse) {
        return categoryService.delete(deleteCategoryResponse);
    }
}
