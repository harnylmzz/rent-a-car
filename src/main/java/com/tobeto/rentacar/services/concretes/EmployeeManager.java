package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.entities.Employee;
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
    public List<GetAllEmployeeResponses> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<GetAllEmployeeResponses> getAllEmployeeResponses = employees.stream()
                .map(employee -> this.modelMapperService.forResponse()
                        .map(employee, GetAllEmployeeResponses.class))
                .collect(Collectors.toList());


        return getAllEmployeeResponses;

    }

    @Override
    public GetByIdEmployeeResponses getById(int id) {
        Employee employee =employeeRepository.findById(id).orElseThrow();
        GetByIdEmployeeResponses getByIdEmployeeResponses = this.modelMapperService.forResponse()
                .map(employee , GetByIdEmployeeResponses.class);


        return getByIdEmployeeResponses;
    }

    @Override
    public void add(CreateEmployeeRequests createEmployeeRequests) {
        Employee employee = this.modelMapperService.forRequest()
                .map(createEmployeeRequests, Employee.class);
        this.employeeRepository.save(employee);


    }

    @Override
    public void update(UpdateEmployeeRequests updateEmployeeRequests) {
        Employee employee =this.modelMapperService.forRequest()
                .map(updateEmployeeRequests, Employee.class);
        employee.setId(updateEmployeeRequests.getId());
        employee.setSalary((float) updateEmployeeRequests.getSalary());

        this.employeeRepository.save(employee);



    }

    @Override
    public void delete(DeleteEmployeeRequests deleteEmployeeRequests) {
        Employee employee = this.modelMapperService.forRequest()
                .map(deleteEmployeeRequests , Employee.class);
        this.employeeRepository.delete(employee);

    }
}
