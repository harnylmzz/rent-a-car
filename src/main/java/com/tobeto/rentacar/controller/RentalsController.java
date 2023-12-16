package com.tobeto.rentacar.controller;

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
    public List<GetAllRentalResponses> getAll() {

        return this.rentalService.getAll();
    }

    @GetMapping("/getById")
    public GetByIdRentalResponses getById(
            int id) {
        return rentalService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateRentalRequests createRentalRequests) {
        this.rentalService.add(createRentalRequests);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateRentalRequests updateRentalRequests) {
        this.rentalService.update(updateRentalRequests);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteRentalRequests deleteRentalRequests) {
        this.rentalService.delete(deleteRentalRequests);
    }

}
