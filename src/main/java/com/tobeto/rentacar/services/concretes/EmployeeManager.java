package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.config.redis.RedisCacheManager;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.Employee;
import com.tobeto.rentacar.repository.EmployeeRepository;
import com.tobeto.rentacar.services.abstracts.EmployeeService;
import com.tobeto.rentacar.services.constans.employee.EmployeeMessages;
import com.tobeto.rentacar.services.dtos.requests.employee.CreateEmployeeRequests;
import com.tobeto.rentacar.services.dtos.requests.employee.DeleteEmployeeRequests;
import com.tobeto.rentacar.services.dtos.requests.employee.UpdateEmployeeRequests;
import com.tobeto.rentacar.services.dtos.responses.employee.GetAllEmployeeResponses;
import com.tobeto.rentacar.services.dtos.responses.employee.GetByIdEmployeeResponses;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeManager implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapperService modelMapperService;
    private final RedisCacheManager redisCacheManager;

    @Override
    public DataResult<List<GetAllEmployeeResponses>> getAll() {

        List<GetAllEmployeeResponses> getAllEmployeeResponses = (List<GetAllEmployeeResponses>) redisCacheManager
                .getCachedData("employeeCache", "getEmployeesAndCache");

        if (getAllEmployeeResponses == null) {
            getAllEmployeeResponses = getEmployeesAndCache();
            redisCacheManager.cacheData("employeeCache", "getEmployeesAndCache", getAllEmployeeResponses);
        }
        return new DataResult<>(getAllEmployeeResponses, true, EmployeeMessages.EMPLOYEES_LISTED);
    }

    public List<GetAllEmployeeResponses> getEmployeesAndCache() {
        List<Employee> employees = employeeRepository.findAll();
        List<GetAllEmployeeResponses> getAllEmployeeResponses = employees.stream()
                .map(employee -> modelMapperService.forResponse().map(employee, GetAllEmployeeResponses.class))
                .collect(Collectors.toList());
        return getAllEmployeeResponses;
    }

    @Override
    public DataResult<GetByIdEmployeeResponses> getById(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Data not found.") {
        });
        GetByIdEmployeeResponses getByIdEmployeeResponses = this.modelMapperService.forResponse()
                .map(employee, GetByIdEmployeeResponses.class);

        return new DataResult<>(getByIdEmployeeResponses, true,EmployeeMessages.EMPLOYEES_LISTED );
    }

    @Override
    public Result add(CreateEmployeeRequests createEmployeeRequests) {

        Employee employee = this.modelMapperService.forRequest()
                .map(createEmployeeRequests, Employee.class);

        this.employeeRepository.save(employee);
        this.redisCacheManager.cacheData("employeeCache", "getEmployeesAndCache", null);

        return new SuccessResult(EmployeeMessages.EMPLOYEE_ADDED);
    }

    @Override
    public Result update(UpdateEmployeeRequests updateEmployeeRequests) {
        Employee employee = this.modelMapperService.forRequest()
                .map(updateEmployeeRequests, Employee.class);
        employee.setId(updateEmployeeRequests.getId());
        employee.setSalary(updateEmployeeRequests.getSalary());

        this.employeeRepository.save(employee);
        this.redisCacheManager.cacheData("employeeCache", "getEmployeesAndCache", null);

        return new SuccessResult(EmployeeMessages.EMPLOYEE_UPDATED);
    }

    @Override
    public Result delete(DeleteEmployeeRequests deleteEmployeeRequests) {
        Employee employee = this.modelMapperService.forRequest()
                .map(deleteEmployeeRequests, Employee.class);
        this.employeeRepository.delete(employee);
        this.redisCacheManager.cacheData("employeeCache", "getEmployeesAndCache", null);

        return new SuccessResult(EmployeeMessages.EMPLOYEE_DELETED);
    }

}
