package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.services.abstracts.FuelTypeService;
import com.tobeto.rentacar.services.dtos.requests.fuelType.CreateFuelTypeRequests;
import com.tobeto.rentacar.services.dtos.requests.fuelType.DeleteFuelTypeRequests;
import com.tobeto.rentacar.services.dtos.requests.fuelType.UpdateFuelTypeRequests;
import com.tobeto.rentacar.services.dtos.responses.fuelType.GetAllFuelTypeResponses;
import com.tobeto.rentacar.services.dtos.responses.fuelType.GetByIdFuelTypeResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing fuel type-related endpoints in the Rent a Car system.
 * Provides endpoints for retrieving, adding, updating, and deleting fuel types.
 * Utilizes the FuelTypeService for fuel type-related operations.
 *
 * @author [Harun Yılmaz]
 */

@RestController
@RequestMapping("/api/v1/fuelTypes")
@RequiredArgsConstructor
@CrossOrigin
public class FuelTypesController {
    private final FuelTypeService fuelTypeService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllFuelTypeResponses>> getAll() {
        return this.fuelTypeService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdFuelTypeResponses> getById(int id) {
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
