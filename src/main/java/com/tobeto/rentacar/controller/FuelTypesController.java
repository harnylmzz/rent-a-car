package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.services.abstracts.FuelTypeService;
import com.tobeto.rentacar.services.dtos.requests.fuelType.CreateFuelTypeRequests;
import com.tobeto.rentacar.services.dtos.requests.fuelType.DeleteFuelTypeRequests;
import com.tobeto.rentacar.services.dtos.requests.fuelType.UpdateFuelTypeRequests;
import com.tobeto.rentacar.services.dtos.responses.fuelType.GetAllFuelTypeResponses;
import com.tobeto.rentacar.services.dtos.responses.fuelType.GetByIdFuelTypeResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fuelTypes")
@AllArgsConstructor
public class FuelTypesController {
    private FuelTypeService fuelTypeService;

    @GetMapping("/getAll")
    public List<GetAllFuelTypeResponses> getAll() {
        return this.fuelTypeService.getAll();
    }
    @GetMapping("/getById")
    public GetByIdFuelTypeResponses getById(int id) {
        return this.fuelTypeService.getById(id);
    }

    @PostMapping("/add")
    public void add(CreateFuelTypeRequests createFuelTypeRequests) {
        this.fuelTypeService.add(createFuelTypeRequests);
    }

    @PutMapping("/update")
    public void update(UpdateFuelTypeRequests updateFuelTypeRequests) {
        this.fuelTypeService.update(updateFuelTypeRequests);
    }

    @DeleteMapping("/delete")
    public void delete(DeleteFuelTypeRequests deleteFuelTypeRequests) {
        this.fuelTypeService.delete(deleteFuelTypeRequests);
    }
}
