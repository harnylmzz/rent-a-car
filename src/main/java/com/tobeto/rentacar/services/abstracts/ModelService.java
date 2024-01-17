package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.dtos.requests.model.CreateModelRequests;
import com.tobeto.rentacar.services.dtos.requests.model.DeleteModelRequests;
import com.tobeto.rentacar.services.dtos.requests.model.UpdateModelRequests;
import com.tobeto.rentacar.services.dtos.responses.model.GetAllModelResponses;
import com.tobeto.rentacar.services.dtos.responses.model.GetByIdModelResponses;

import java.util.List;

/**
 * Service interface for managing model-related operations.
 * Defines methods for retrieving, adding, updating, and deleting models.
 * Uses Data Transfer Objects (DTOs) for requests and responses.
 * Provides both individual and list-based retrieval of model information.
 * Supports CRUD (Create, Read, Update, Delete) operations for models.
 *
 * @author [Harun Yılmaz]
 */

public interface ModelService {
    DataResult<List<GetAllModelResponses>> getAll();

    DataResult<GetByIdModelResponses> getById(int id);

    Result add(CreateModelRequests createModelRequests);

    Result update(UpdateModelRequests updateModelRequests);

    Result delete(DeleteModelRequests deleteModelRequests);

    List<GetAllModelResponses> findByName(String name);
}
