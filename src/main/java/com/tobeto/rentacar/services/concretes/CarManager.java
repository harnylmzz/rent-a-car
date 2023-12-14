package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.entities.Car;
import com.tobeto.rentacar.repository.CarRepository;
import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.dtos.requests.car.CreateCarRequests;
import com.tobeto.rentacar.services.dtos.requests.car.DeleteCarRequests;
import com.tobeto.rentacar.services.dtos.requests.car.UpdateCarRequests;
import com.tobeto.rentacar.services.dtos.responses.car.GetAllCarResponses;
import com.tobeto.rentacar.services.dtos.responses.car.GetByIdCarResponses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllCarResponses> getAll() {
        List<Car> cars = carRepository.findAll();
        List<GetAllCarResponses> getAllCarResponses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarResponses.class))
                .collect(Collectors.toList());

        return getAllCarResponses;
    }

    @Override
    public GetByIdCarResponses getById(int id) {
        Car car = carRepository.findById(id).orElseThrow();
        GetByIdCarResponses getByIdCarResponses = this.modelMapperService.forResponse()
                .map(car, GetByIdCarResponses.class);

        return getByIdCarResponses;
    }

    @Override
    public void add(CreateCarRequests createBrandRequests) {
        Car car = this.modelMapperService.forRequest()
                .map(createBrandRequests, Car.class);

        if (car.getKilometer() < 0) {
            throw new IllegalArgumentException("Kilometer field cannot be less than 0!");
        }

        String plate = createBrandRequests.getPlate().replaceAll("\\s+", "");
        car.setPlate(plate);

        int year = car.getYear();
        if (year < 2005 || year > 2024) {
            throw new IllegalArgumentException("Year information should be between 2005 and 2024.");
        }

        if (car.getPrice() < 0) {
            throw new IllegalArgumentException("DailyPrice cannot be less than 0.");
        }

        this.carRepository.save(car);
    }


    @Override
    public void update(UpdateCarRequests updateCarRequests) {
        Car car = this.modelMapperService.forRequest()
                .map(updateCarRequests, Car.class);
        car.setId(updateCarRequests.getId());
        car.setKilometer(updateCarRequests.getKilometer());
        car.setYear(updateCarRequests.getYear());
        car.setPlate(updateCarRequests.getPlate());
        car.setPrice(updateCarRequests.getPrice());
        this.carRepository.save(car);

    }

    @Override
    public void delete(DeleteCarRequests deleteCarRequests) {
        Car car = this.modelMapperService.forRequest()
                .map(deleteCarRequests, Car.class);
        this.carRepository.delete(car);

    }
}
