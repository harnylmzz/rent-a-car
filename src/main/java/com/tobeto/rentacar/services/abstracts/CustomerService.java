package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.dtos.requests.customer.CreateCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.customer.DeleteCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.customer.UpdateCustomerRequests;
import com.tobeto.rentacar.services.dtos.responses.brand.GetAllBrandResponses;
import com.tobeto.rentacar.services.dtos.responses.customer.GetAllCustomerResponses;
import com.tobeto.rentacar.services.dtos.responses.customer.GetByIdCustomerResponses;

import java.util.List;

/**
 * Service interface for managing customer-related operations.
 * Defines methods for retrieving, adding, updating, and deleting customers.
 * Uses Data Transfer Objects (DTOs) for requests and responses.
 * Provides both individual and list-based retrieval of customer information.
 * Supports CRUD (Create, Read, Update, Delete) operations for customers.
 *
 * @author [Harun Yılmaz]
 */

public interface CustomerService {
    DataResult<List<GetAllCustomerResponses>> getAll();

    DataResult<GetByIdCustomerResponses> getById(int id);

    Result add(CreateCustomerRequests createCustomerRequests);

    Result update(UpdateCustomerRequests updateCustomerRequests);

    Result delete(DeleteCustomerRequests deleteCustomerRequests);

}
