package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.dtos.requests.customer.CreateCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.customer.DeleteCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.customer.UpdateCustomerRequests;
import com.tobeto.rentacar.services.dtos.responses.customer.GetAllCustomerResponses;
import com.tobeto.rentacar.services.dtos.responses.customer.GetByIdCustomerResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomersController {
    private CustomerService customerService;
    @GetMapping("/getAll")
    public List<GetAllCustomerResponses> getAll() {
        return this.customerService.getAll();
    }

    @GetMapping("/getById")
    public GetByIdCustomerResponses getById(int id) {
        return customerService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateCustomerRequests createBrandRequests) {
        this.customerService.add(createBrandRequests);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateCustomerRequests updateCustomerRequest) {
        this.customerService.update(updateCustomerRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteCustomerRequests deleteCustomerRequests) {
        this.customerService.delete(deleteCustomerRequests);
    }
}
