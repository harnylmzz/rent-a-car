package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.entities.Car;
import com.tobeto.rentacar.entities.Color;
import com.tobeto.rentacar.entities.Model;
import com.tobeto.rentacar.repository.CarRepository;
import com.tobeto.rentacar.repository.ColorRepository;
import com.tobeto.rentacar.repository.ModelRepository;
import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.dtos.requests.car.CreateCarRequests;
import com.tobeto.rentacar.services.dtos.requests.car.DeleteCarRequests;
import com.tobeto.rentacar.services.dtos.requests.car.UpdateCarRequests;
import com.tobeto.rentacar.services.dtos.responses.car.GetAllCarResponses;
import com.tobeto.rentacar.services.dtos.responses.car.GetByIdCarResponses;
import com.tobeto.rentacar.services.rules.CarBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;
   // private ColorRepository colorRepository;
   // private ModelRepository modelRepository;
    private CarBusinessRules carBusinessRules;

    @Override
    public DataResult<List<GetAllCarResponses>> getAll() {
        List<Car> cars = carRepository.findAll();
        List<GetAllCarResponses> getAllCarResponses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarResponses.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllCarResponses, true, "Cars listed");
    }

    @Override
    public DataResult<GetByIdCarResponses> getById(int id) {
        Car car = carRepository.findById(id).orElseThrow();
        GetByIdCarResponses getByIdCarResponses = this.modelMapperService.forResponse()
                .map(car, GetByIdCarResponses.class);

        return new DataResult<>(getByIdCarResponses, true, "Car listed");
    }

    @Override
    public Result add(CreateCarRequests createCarRequests) {

        String plate = createCarRequests.getPlate().replace(" ", "");

        this.carBusinessRules.checkIfPlate(createCarRequests.getPlate());

        this.carBusinessRules.checkIfKilometer(createCarRequests);

        this.carBusinessRules.checkIfYear(createCarRequests);

        this.carBusinessRules.checkIfPrice(createCarRequests);

        Car car = this.modelMapperService.forRequest()
                .map(createCarRequests, Car.class);

        car.setPlate(plate);

        this.carRepository.save(car);

        return new Result(true, "Car added");
    }


    @Override
    public Result update(UpdateCarRequests updateCarRequests) {
        Car car = this.modelMapperService.forRequest()
                .map(updateCarRequests, Car.class);
        car.setId(updateCarRequests.getId());
        car.setKilometer(updateCarRequests.getKilometer());
        car.setYear(updateCarRequests.getYear());
        car.setPlate(updateCarRequests.getPlate());
        car.setPrice(updateCarRequests.getPrice());
        this.carRepository.save(car);

        return new Result(true, "Car updated");

    }

    @Override
    public Result delete(DeleteCarRequests deleteCarRequests) {
        Car car = this.modelMapperService.forRequest()
                .map(deleteCarRequests, Car.class);
        this.carRepository.delete(car);

        return new Result(true, "Car deleted");

    }
}
