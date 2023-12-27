package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.Employee;
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
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllEmployeeResponses>> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<GetAllEmployeeResponses> getAllEmployeeResponses = employees.stream()
                .map(employee -> this.modelMapperService.forResponse()
                        .map(employee, GetAllEmployeeResponses.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllEmployeeResponses, true, "Employees listed");
    }

    @Override
    public DataResult<GetByIdEmployeeResponses> getById(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Data not found.") {
        });
        GetByIdEmployeeResponses getByIdEmployeeResponses = this.modelMapperService.forResponse()
                .map(employee, GetByIdEmployeeResponses.class);

        return new DataResult<>(getByIdEmployeeResponses, true, "Employee listed");
    }

    @Override
    public Result add(CreateEmployeeRequests createEmployeeRequests) {

        Employee employee = this.modelMapperService.forRequest()
                .map(createEmployeeRequests, Employee.class);

        this.employeeRepository.save(employee);


        return new SuccessResult("Employee added");
    }

    @Override
    public Result update(UpdateEmployeeRequests updateEmployeeRequests) {
        Employee employee = this.modelMapperService.forRequest()
                .map(updateEmployeeRequests, Employee.class);
        employee.setId(updateEmployeeRequests.getId());
        employee.setSalary(updateEmployeeRequests.getSalary());

        this.employeeRepository.save(employee);

        return new SuccessResult("Employee updated");
    }

    @Override
    public Result delete(DeleteEmployeeRequests deleteEmployeeRequests) {
        Employee employee = this.modelMapperService.forRequest()
                .map(deleteEmployeeRequests, Employee.class);
        this.employeeRepository.delete(employee);

        return new SuccessResult("Employee deleted");
    }

}
