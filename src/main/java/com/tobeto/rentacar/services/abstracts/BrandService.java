package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.dtos.requests.brand.CreateBrandRequests;
import com.tobeto.rentacar.services.dtos.requests.brand.DeleteBrandRequests;
import com.tobeto.rentacar.services.dtos.requests.brand.UpdateBrandRequests;
import com.tobeto.rentacar.services.dtos.responses.brand.GetAllBrandResponses;
import com.tobeto.rentacar.services.dtos.responses.brand.GetByIdBrandResponses;

import java.util.List;

/**
 * Service interface for managing brand-related operations.
 * Defines methods for retrieving, adding, updating, and deleting brands.
 * Also includes methods for finding brands by name or name patterns.
 * Uses Data Transfer Objects (DTOs) for requests and responses.
 * Provides both individual and list-based retrieval of brand information.
 * Supports CRUD (Create, Read, Update, Delete) operations for brands.
 *
 * @author [Harun Yılmaz]
 */

public interface BrandService {

    DataResult<List<GetAllBrandResponses>> getAll();

    DataResult<GetByIdBrandResponses> getById(int id);

    Result add(CreateBrandRequests createBrandRequests);

    Result update(UpdateBrandRequests updateBrandRequests);

    Result delete(DeleteBrandRequests deleteBrandRequests);

    List<GetAllBrandResponses> findByName(String name);

    List<GetAllBrandResponses> findByNameStartingWith(String name);

    List<GetAllBrandResponses> findByNameEndingWith(String name);

    List<GetAllBrandResponses> findByNameContaining(String name);

}
