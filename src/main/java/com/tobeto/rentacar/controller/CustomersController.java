package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.dtos.requests.customer.CreateCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.customer.DeleteCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.customer.UpdateCustomerRequests;
import com.tobeto.rentacar.services.dtos.responses.brand.GetAllBrandResponses;
import com.tobeto.rentacar.services.dtos.responses.customer.GetAllCustomerResponses;
import com.tobeto.rentacar.services.dtos.responses.customer.GetByIdCustomerResponses;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@CrossOrigin
public class CustomersController {
    private final CustomerService customerService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllCustomerResponses>> getAll() {
        return this.customerService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdCustomerResponses> getById(int id) {
        return customerService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateCustomerRequests createCustomerRequests) {
        return customerService.add(createCustomerRequests);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateCustomerRequests updateCustomerRequest) {
        return this.customerService.update(updateCustomerRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteCustomerRequests deleteCustomerRequests) {
        return this.customerService.delete(deleteCustomerRequests);
    }

}
