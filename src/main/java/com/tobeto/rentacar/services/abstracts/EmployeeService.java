package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.entities.Employee;
import com.tobeto.rentacar.services.dtos.requests.employee.CreateEmployeeRequests;
import com.tobeto.rentacar.services.dtos.requests.employee.DeleteEmployeeRequests;
import com.tobeto.rentacar.services.dtos.requests.employee.UpdateEmployeeRequests;
import com.tobeto.rentacar.services.dtos.responses.employee.GetAllEmployeeResponses;
import com.tobeto.rentacar.services.dtos.responses.employee.GetByIdEmployeeResponses;

import java.util.List;

public interface EmployeeService {
    List<GetAllEmployeeResponses> getAll();
    GetByIdEmployeeResponses getById(int id);
    void add(CreateEmployeeRequests createEmployeeRequests);
    void update(UpdateEmployeeRequests updateEmployeeRequests);
    void delete(DeleteEmployeeRequests deleteEmployeeRequests);
}
