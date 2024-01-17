package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.dtos.requests.fuelType.CreateFuelTypeRequests;
import com.tobeto.rentacar.services.dtos.requests.fuelType.DeleteFuelTypeRequests;
import com.tobeto.rentacar.services.dtos.requests.fuelType.UpdateFuelTypeRequests;
import com.tobeto.rentacar.services.dtos.responses.fuelType.GetAllFuelTypeResponses;
import com.tobeto.rentacar.services.dtos.responses.fuelType.GetByIdFuelTypeResponses;

import java.util.List;

/**
 * Service interface for managing fuel type-related operations.
 * Defines methods for retrieving, adding, updating, and deleting fuel types.
 * Uses Data Transfer Objects (DTOs) for requests and responses.
 * Provides both individual and list-based retrieval of fuel type information.
 * Supports CRUD (Create, Read, Update, Delete) operations for fuel types.
 *
 * @author [Harun Yılmaz]
 */

public interface FuelTypeService {
    DataResult<List<GetAllFuelTypeResponses>> getAll();
    DataResult<GetByIdFuelTypeResponses> getById(int id);
    Result add(CreateFuelTypeRequests createFuelTypeRequests);
    Result update(UpdateFuelTypeRequests updateFuelTypeRequests);
    Result delete(DeleteFuelTypeRequests deleteFuelTypeRequests);
}
