package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.dtos.requests.employee.CreateEmployeeRequests;
import com.tobeto.rentacar.services.dtos.requests.employee.DeleteEmployeeRequests;
import com.tobeto.rentacar.services.dtos.requests.employee.UpdateEmployeeRequests;
import com.tobeto.rentacar.services.dtos.responses.employee.GetAllEmployeeResponses;
import com.tobeto.rentacar.services.dtos.responses.employee.GetByIdEmployeeResponses;

import java.util.List;

/**
 * Service interface for managing employee-related operations.
 * Defines methods for retrieving, adding, updating, and deleting employees.
 * Uses Data Transfer Objects (DTOs) for requests and responses.
 * Provides both individual and list-based retrieval of employee information.
 * Supports CRUD (Create, Read, Update, Delete) operations for employees.
 *
 * @author [Harun Yılmaz]
 */

public interface EmployeeService {
    DataResult<List<GetAllEmployeeResponses>> getAll();

    DataResult<GetByIdEmployeeResponses> getById(int id);

    Result add(CreateEmployeeRequests createEmployeeRequests);

    Result update(UpdateEmployeeRequests updateEmployeeRequests);

    Result delete(DeleteEmployeeRequests deleteEmployeeRequests);

}
