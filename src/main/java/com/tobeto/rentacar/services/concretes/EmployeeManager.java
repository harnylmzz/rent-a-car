package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.repository.EmployeeRepository;
import com.tobeto.rentacar.services.abstracts.EmployeeService;
import com.tobeto.rentacar.services.dtos.requests.employee.CreateEmployeeRequests;
import com.tobeto.rentacar.services.dtos.requests.employee.DeleteEmployeeRequests;
import com.tobeto.rentacar.services.dtos.requests.employee.UpdateEmployeeRequests;
import com.tobeto.rentacar.services.dtos.responses.employee.GetAllEmployeeResponses;
import com.tobeto.rentacar.services.dtos.responses.employee.GetByIdEmployeeResponses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllEmployeeResponses> getAll() {
        return null;
    }

    @Override
    public GetByIdEmployeeResponses getById(int id) {
        return null;
    }

    @Override
    public void add(CreateEmployeeRequests createEmployeeRequests) {

    }

    @Override
    public void update(UpdateEmployeeRequests updateEmployeeRequests) {

    }

    @Override
    public void delete(DeleteEmployeeRequests deleteEmployeeRequests) {

    }
}
