package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.entities.Employee;
import com.tobeto.rentacar.services.dtos.requests.employee.CreateEmployeeRequests;
import com.tobeto.rentacar.services.dtos.requests.employee.DeleteEmployeeRequests;
import com.tobeto.rentacar.services.dtos.requests.employee.UpdateEmployeeRequests;
import com.tobeto.rentacar.services.dtos.responses.employee.GetAllEmployeeResponses;
import com.tobeto.rentacar.services.dtos.responses.employee.GetByIdEmployeeResponses;

import java.util.List;

public interface EmployeeService {
    DataResult<List<GetAllEmployeeResponses>> getAll();

    DataResult<GetByIdEmployeeResponses> getById(int id);

    Result add(CreateEmployeeRequests createEmployeeRequests);

    Result update(UpdateEmployeeRequests updateEmployeeRequests);

    Result delete(DeleteEmployeeRequests deleteEmployeeRequests);
}
