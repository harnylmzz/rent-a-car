package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.services.abstracts.EmployeeService;
import com.tobeto.rentacar.services.dtos.requests.employee.CreateEmployeeRequests;
import com.tobeto.rentacar.services.dtos.requests.employee.DeleteEmployeeRequests;
import com.tobeto.rentacar.services.dtos.requests.employee.UpdateEmployeeRequests;
import com.tobeto.rentacar.services.dtos.responses.employee.GetAllEmployeeResponses;
import com.tobeto.rentacar.services.dtos.responses.employee.GetByIdEmployeeResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeesController {
    private EmployeeService employeeService;

    @GetMapping("/getAll")
    public List<GetAllEmployeeResponses> getAll() {
        return this.employeeService.getAll();
    }

    @GetMapping("/getById")
    public GetByIdEmployeeResponses getById(int id) {
        return employeeService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateEmployeeRequests createEmployeeRequests) {
        this.employeeService.add(createEmployeeRequests);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateEmployeeRequests updateEmployeeRequest) {
        this.employeeService.update(updateEmployeeRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteEmployeeRequests deleteEmployeeRequests) {
        this.employeeService.delete(deleteEmployeeRequests);
    }
}
