package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.dtos.requests.insurance.CreateInsuranceRequests;
import com.tobeto.rentacar.services.dtos.requests.insurance.DeleteInsuranceRequests;
import com.tobeto.rentacar.services.dtos.requests.insurance.UpdateInsuranceRequests;
import com.tobeto.rentacar.services.dtos.responses.insurance.GetAllInsuranceResponses;
import com.tobeto.rentacar.services.dtos.responses.insurance.GetByIdInsuranceResponses;

import java.util.List;

/**
 * Service interface for managing insurance-related operations.
 * Defines methods for retrieving, adding, updating, and deleting insurances.
 * Uses Data Transfer Objects (DTOs) for requests and responses.
 * Provides both individual and list-based retrieval of insurance information.
 * Supports CRUD (Create, Read, Update, Delete) operations for insurances.
 *
 * @author [Harun Yılmaz]
 */

public interface InsuranceService {

    DataResult<List<GetAllInsuranceResponses>> getAll();

    DataResult<GetByIdInsuranceResponses> getById(int id);

    Result add(CreateInsuranceRequests createInsuranceRequests);

    Result update(UpdateInsuranceRequests updateInsuranceRequests);

    Result delete(DeleteInsuranceRequests deleteInsuranceRequests);
}
