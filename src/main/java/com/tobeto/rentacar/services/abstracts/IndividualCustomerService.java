package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.dtos.requests.individualCustomer.CreateIndividualCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.individualCustomer.DeleteIndividualCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.individualCustomer.UpdateIndividualCustomerRequests;
import com.tobeto.rentacar.services.dtos.responses.individualCustomer.GetAllIndividualCustomerResponses;
import com.tobeto.rentacar.services.dtos.responses.individualCustomer.GetByIdIndividualCustomerResponses;

import java.util.List;

/**
 * Service interface for managing individual customer-related operations.
 * Defines methods for retrieving, adding, updating, and deleting individual customers.
 * Uses Data Transfer Objects (DTOs) for requests and responses.
 * Provides both individual and list-based retrieval of individual customer information.
 * Supports CRUD (Create, Read, Update, Delete) operations for individual customers.
 *
 * @author [Harun Yılmaz]
 */

public interface IndividualCustomerService {

    DataResult<List<GetAllIndividualCustomerResponses>> getAll();

    DataResult<GetByIdIndividualCustomerResponses> getById(int id);

    Result add(CreateIndividualCustomerRequests createIndividualCustomerRequests);

    Result update(UpdateIndividualCustomerRequests updateIndividualCustomerRequests);

    Result delete(DeleteIndividualCustomerRequests deleteIndividualCustomerRequests);

}
