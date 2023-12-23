package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.RentalService;
import com.tobeto.rentacar.services.dtos.requests.rental.CreateRentalRequests;
import com.tobeto.rentacar.services.dtos.requests.rental.DeleteRentalRequests;
import com.tobeto.rentacar.services.dtos.requests.rental.UpdateRentalRequests;
import com.tobeto.rentacar.services.dtos.responses.rental.GetAllRentalResponses;
import com.tobeto.rentacar.services.dtos.responses.rental.GetByIdRentalResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rentals")
public class RentalsController {
    private RentalService rentalService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllRentalResponses>> getAll() {

        return this.rentalService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdRentalResponses> getById(int id) {
        return rentalService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateRentalRequests createRentalRequests) {
        return this.rentalService.add(createRentalRequests);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateRentalRequests updateRentalRequests) {
        return this.rentalService.update(updateRentalRequests);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteRentalRequests deleteRentalRequests) {
        return this.rentalService.delete(deleteRentalRequests);
    }
}
