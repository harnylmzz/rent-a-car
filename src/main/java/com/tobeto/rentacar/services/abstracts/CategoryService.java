package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.dtos.requests.car.CreateCarRequests;
import com.tobeto.rentacar.services.dtos.requests.car.DeleteCarRequests;
import com.tobeto.rentacar.services.dtos.requests.car.UpdateCarRequests;
import com.tobeto.rentacar.services.dtos.requests.category.CreateCategoryRequests;
import com.tobeto.rentacar.services.dtos.requests.category.DeleteCategoryRequests;
import com.tobeto.rentacar.services.dtos.requests.category.UpdateCategoryRequests;
import com.tobeto.rentacar.services.dtos.responses.brand.GetAllBrandResponses;
import com.tobeto.rentacar.services.dtos.responses.car.GetAllCarResponses;
import com.tobeto.rentacar.services.dtos.responses.car.GetByIdCarResponses;
import com.tobeto.rentacar.services.dtos.responses.category.GetAllCategoryResponse;
import com.tobeto.rentacar.services.dtos.responses.category.GetByIdCategoryResponse;

import java.util.List;

/**
 * Service interface for managing category-related operations.
 * Defines methods for retrieving, adding, updating, and deleting categories.
 * Uses Data Transfer Objects (DTOs) for requests and responses.
 * Provides both individual and list-based retrieval of category information.
 * Supports CRUD (Create, Read, Update, Delete) operations for categories.
 *
 * @author [Harun Yılmaz]
 */

public interface CategoryService {
    DataResult<List<GetAllCategoryResponse>> getAll();

    DataResult<GetByIdCategoryResponse> getById(int id);

    Result add(CreateCategoryRequests createCategoryRequests);

    Result update(UpdateCategoryRequests updateCategoryRequests);

    Result delete(DeleteCategoryRequests deleteCategoryRequests);

    List<GetAllCategoryResponse> findByName(String name);

    List<GetAllCategoryResponse> findByNameStartingWith(String name);

    List<GetAllCategoryResponse> findByNameEndingWith(String name);

    List<GetAllCategoryResponse> findByNameContaining(String name);
}
