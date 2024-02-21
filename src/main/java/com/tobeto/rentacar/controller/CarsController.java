package com.tobeto.rentacar.controller;

import com.stripe.model.tax.Registration;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.dtos.requests.car.CreateCarRequests;
import com.tobeto.rentacar.services.dtos.requests.car.DeleteCarRequests;
import com.tobeto.rentacar.services.dtos.requests.car.UpdateCarRequests;
import com.tobeto.rentacar.services.dtos.responses.car.GetAllCarResponses;
import com.tobeto.rentacar.services.dtos.responses.car.GetByIdCarResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling car-related endpoints in the Rent a Car system.
 * Provides endpoints for retrieving, adding, updating, and deleting cars.
 * Utilizes the CarService for car-related operations.
 * Supports validation for request bodies.
 *
 * @author [Harun Yılmaz]
 */

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
@CrossOrigin
public class CarsController {

    private final CarService carService;

    @GetMapping("/getAll")
    @CrossOrigin(origins = "http://localhost:5173")
    public DataResult<List<GetAllCarResponses>> getAll() {

        return this.carService.getAll();
    }

    @GetMapping("/getById")
    @CrossOrigin(origins = "http://localhost:5173")
    public DataResult<GetByIdCarResponses> getById(int id) {
        return carService.getById(id);
    }

    @GetMapping("/getByCategoryId")
    @CrossOrigin(origins = "http://localhost:5173")
    public DataResult<List<GetAllCarResponses>> getByCategoryId(int categoryId) {
        return carService.getByCategoryId(categoryId);
    }

    @GetMapping("/getByColorId")
    @CrossOrigin(origins = "http://localhost:5173")
    public DataResult<List<GetAllCarResponses>> getByColorId(int colorId) {
        return carService.getByColorId(colorId);
    }

    @GetMapping("/getByFuelTypeId")
    @CrossOrigin(origins = "http://localhost:5173")
    public DataResult<List<GetAllCarResponses>> getByFuelTypeId(int fuelTypeId) {
        return carService.getByFuelTypeId(fuelTypeId);
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "http://localhost:5173")
    public Result add(@RequestBody @Valid CreateCarRequests createCarRequests) {
        return this.carService.add(createCarRequests);
    }

    @PutMapping("/update")
    @CrossOrigin(origins = "http://localhost:5173")
    public Result update(@RequestBody UpdateCarRequests updateCarRequest) {
        return this.carService.update(updateCarRequest);
    }

    @DeleteMapping("/delete")
    @CrossOrigin(origins = "http://localhost:5173")
    public Result delete(DeleteCarRequests deleteCarRequests) {
        return this.carService.delete(deleteCarRequests);
    }

    @GetMapping("/findByYear")
    @CrossOrigin(origins = "http://localhost:5173")
    public List<GetAllCarResponses> findByYear(int year) {
        return this.carService.findByYear(year);
    }

    @GetMapping("/findByPlate")
    @CrossOrigin(origins = "http://localhost:5173")
    public List<GetAllCarResponses> findByPlate(String plate) {
        return this.carService.findByPlate(plate);
    }

    @GetMapping("/findByGearType")
    public List<GetAllCarResponses> findByGearType(String gearType) {
        return this.carService.findByGearType(gearType);
    }

    @GetMapping("/findByKilometer")
    public List<GetAllCarResponses> findByKilometer(int kilometer) {
        return this.carService.findByKilometer(kilometer);
    }

    @GetMapping("/findByPrice")
    public List<GetAllCarResponses> findByPrice(double price) {
        return this.carService.findByPrice(price);
    }
}

