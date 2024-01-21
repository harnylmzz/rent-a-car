package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.IndividualCustomerService;
import com.tobeto.rentacar.services.dtos.requests.individualCustomer.CreateIndividualCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.individualCustomer.DeleteIndividualCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.individualCustomer.UpdateIndividualCustomerRequests;
import com.tobeto.rentacar.services.dtos.responses.individualCustomer.GetAllIndividualCustomerResponses;
import com.tobeto.rentacar.services.dtos.responses.individualCustomer.GetByIdIndividualCustomerResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/individualCustomers")
@RestController
public class IndividualCustomersController {

    private final IndividualCustomerService individualCustomerService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllIndividualCustomerResponses>> getAll(){
        return this.individualCustomerService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdIndividualCustomerResponses> getById(int id){
        return this.individualCustomerService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateIndividualCustomerRequests createIndividualCustomerRequests) {
        return this.individualCustomerService.add(createIndividualCustomerRequests);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateIndividualCustomerRequests updateIndividualCustomerRequests) {
        return this.individualCustomerService.update(updateIndividualCustomerRequests);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteIndividualCustomerRequests deleteIndividualCustomerRequests) {
        return this.individualCustomerService.delete(deleteIndividualCustomerRequests);
    }
}
