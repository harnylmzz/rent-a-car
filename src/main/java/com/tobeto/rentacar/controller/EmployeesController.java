package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
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
    public DataResult<List<GetAllEmployeeResponses>> getAll() {
        return this.employeeService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdEmployeeResponses> getById(int id) {
        return employeeService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateEmployeeRequests createEmployeeRequests) {
        return this.employeeService.add(createEmployeeRequests);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateEmployeeRequests updateEmployeeRequest) {
        return this.employeeService.update(updateEmployeeRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteEmployeeRequests deleteEmployeeRequests) {
        return this.employeeService.delete(deleteEmployeeRequests);
    }
}
