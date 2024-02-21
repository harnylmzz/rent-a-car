package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.CorporateCustomerService;
import com.tobeto.rentacar.services.dtos.requests.corporateCustomer.CreateCorporateCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.corporateCustomer.DeleteCorporateCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.corporateCustomer.UpdateCorporateCustomerRequests;
import com.tobeto.rentacar.services.dtos.responses.corporateCustomer.GetAllCorporateCustomer;
import com.tobeto.rentacar.services.dtos.responses.corporateCustomer.GetByIdCorporateCustomer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing corporate customer-related endpoints in the Rent a Car system.
 * Provides endpoints for retrieving, adding, updating, and deleting corporate customers.
 * Utilizes the CorporateCustomerService for corporate customer-related operations.
 *
 * @Author [Harun Yılmaz]
 */

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/corporateCustomers")
public class CorporateCustomersController {

    private final CorporateCustomerService corporateCustomerService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllCorporateCustomer>> getAll() {
        return corporateCustomerService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdCorporateCustomer> getById(int id) {
        return corporateCustomerService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateCorporateCustomerRequests createCorporateCustomerRequests) {
        return corporateCustomerService.add(createCorporateCustomerRequests);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateCorporateCustomerRequests updateCorporateCustomerRequests) {
        return corporateCustomerService.update(updateCorporateCustomerRequests);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteCorporateCustomerRequests deleteCorporateCustomerRequests) {
        return corporateCustomerService.delete(deleteCorporateCustomerRequests);
    }
}
