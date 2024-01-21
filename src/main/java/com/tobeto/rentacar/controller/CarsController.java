package com.tobeto.rentacar.controller;

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

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
@CrossOrigin
public class CarsController {

    private final CarService carService;

    @GetMapping("/getAll")
    @CrossOrigin(origins = "http://localhost:5173")
    public DataResult<List<GetAllCarResponses>> getAll() {

        return this.carService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getById")
    public DataResult<GetByIdCarResponses> getById(int id) {
        return carService.getById(id);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateCarRequests createCarRequests) {
        return this.carService.add(createCarRequests);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PutMapping("/update")
    public Result update(@RequestBody UpdateCarRequests updateCarRequest) {
        return this.carService.update(updateCarRequest);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("/delete")
    public Result delete(DeleteCarRequests deleteCarRequests) {
        return this.carService.delete(deleteCarRequests);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/findByYear")
    public List<GetAllCarResponses> findByYear(int year) {
        return this.carService.findByYear(year);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/findByPlate")
    public List<GetAllCarResponses> findByPlate(String plate) {
        return this.carService.findByPlate(plate);
    }
}
