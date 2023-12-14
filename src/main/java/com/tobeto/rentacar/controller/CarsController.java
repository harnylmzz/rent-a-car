package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.dtos.requests.car.CreateCarRequests;
import com.tobeto.rentacar.services.dtos.requests.car.DeleteCarRequests;
import com.tobeto.rentacar.services.dtos.requests.car.UpdateCarRequests;
import com.tobeto.rentacar.services.dtos.responses.car.GetAllCarResponses;
import com.tobeto.rentacar.services.dtos.responses.car.GetByIdCarResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
    private CarService carService;

    @GetMapping("/getAll")
    public List<GetAllCarResponses> getAll(){
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdCarResponses getById(
            @PathVariable int id){
        return carService.getById(id);
    }
    @PostMapping("/add")
    public void add(@RequestBody CreateCarRequests createCarRequests){
        this.carService.add(createCarRequests);
    }

    @PutMapping("/update")
    public void update( @RequestBody UpdateCarRequests updateCarRequest){
        this.carService.update(updateCarRequest);
    }

    @DeleteMapping("/{id}")
    public void delete( @RequestBody DeleteCarRequests deleteCarRequests ){
        this.carService.delete(deleteCarRequests);
    }


}
