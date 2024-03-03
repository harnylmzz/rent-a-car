package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.config.redis.RedisCacheManager;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessDataResult;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.*;
import com.tobeto.rentacar.repository.CarRepository;
import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.dtos.requests.car.CreateCarRequests;
import com.tobeto.rentacar.services.dtos.requests.car.DeleteCarRequests;
import com.tobeto.rentacar.services.dtos.requests.car.UpdateCarRequests;
import com.tobeto.rentacar.services.dtos.responses.car.GetAllCarResponses;
import com.tobeto.rentacar.services.dtos.responses.car.GetByIdCarResponses;
import com.tobeto.rentacar.services.constans.car.CarMessages;
import com.tobeto.rentacar.services.rules.car.CarBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private final ModelMapperService modelMapperService;
    private final CarBusinessRules carBusinessRules;
    private final RedisCacheManager redisCacheManager;

    @Override
    public DataResult<List<GetAllCarResponses>> getAll() {

        List<Car> cars = carRepository.findAll();
        List<GetAllCarResponses> getAllCarResponses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarResponses.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(getAllCarResponses, CarMessages.CARS_LISTED);
    }

    @Override
    public DataResult<GetByIdCarResponses> getById(int id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new DataNotFoundException(CarMessages.CAR_NOT_FOUND));
        GetByIdCarResponses getByIdCarResponses = this.modelMapperService.forResponse()
                .map(car, GetByIdCarResponses.class);

        return new DataResult<>(getByIdCarResponses, true, CarMessages.CARS_LISTED);
    }

    @Override
    public DataResult<List<GetAllCarResponses>> getByCategoryId(int categoryId) {
        List<Car> cars = carRepository.findByCategoryId(categoryId);
        List<GetAllCarResponses> getByCategoryIdCarResponses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarResponses.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(getByCategoryIdCarResponses, CarMessages.CARS_LISTED);
    }

    @Override
    public DataResult<List<GetAllCarResponses>> getByColorId(int colorId) {
        List<Car> cars = carRepository.findByColorId(colorId);
        List<GetAllCarResponses> getByColorIdCarResponses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarResponses.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(getByColorIdCarResponses, CarMessages.CARS_LISTED);
    }

    @Override
    public DataResult<List<GetAllCarResponses>> getByFuelTypeId(int fuelTypeId) {

        List<Car> cars = carRepository.findByFuelTypeId(fuelTypeId);
        List<GetAllCarResponses> getByFuelTypeIdCarResponses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarResponses.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(getByFuelTypeIdCarResponses, CarMessages.CARS_LISTED);
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

        return new SuccessResult(CarMessages.CAR_ADDED);
    }


    @Override
    public Result update(UpdateCarRequests updateCarRequests) {
        Car car = this.modelMapperService.forRequest()
                .map(updateCarRequests, Car.class);
        car.setId(updateCarRequests.getId());
        car.setPrice(updateCarRequests.getPrice());
        car.setYear(updateCarRequests.getYear());
        car.setKilometer(updateCarRequests.getKilometer());
        car.setGearType(updateCarRequests.getGearType());
        car.setPlate(updateCarRequests.getPlate());
        car.setDescription(updateCarRequests.getDescription());
        car.setNumberOfSeats(updateCarRequests.getNumberOfSeats());

    this.carRepository.save(car);

        return new SuccessResult(CarMessages.CAR_UPDATED);

    }

    @Override
    public Result delete(DeleteCarRequests deleteCarRequests) {
        Car car = this.modelMapperService.forRequest()
                .map(deleteCarRequests, Car.class);
        this.carRepository.delete(car);

        return new SuccessResult(CarMessages.CAR_DELETED);

    }

    @Override
    public List<GetAllCarResponses> findByYear(int year) {

        List<Car> cars = carRepository.findByYear(year);
        List<GetAllCarResponses> findByYearCarResponses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarResponses.class))
                .collect(Collectors.toList());

        return findByYearCarResponses;
    }

    @Override
    public List<GetAllCarResponses> findByPlate(String plate) {

        List<Car> cars = carRepository.findByPlate(plate);
        List<GetAllCarResponses> findByPlateCarResponses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarResponses.class))
                .collect(Collectors.toList());

        return findByPlateCarResponses;
    }

    @Override
    public List<GetAllCarResponses> findByGearType(String gearType) {
        List<Car> cars = carRepository.findByGearType(gearType);
        List<GetAllCarResponses> findByGearTypeCarResponses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarResponses.class))
                .collect(Collectors.toList());
        return findByGearTypeCarResponses;
    }

    @Override
    public List<GetAllCarResponses> findByKilometer(int kilometer) {
        List<Car> cars = carRepository.findByKilometer(kilometer);
        List<GetAllCarResponses> findByKilometerCarResponses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarResponses.class))
                .collect(Collectors.toList());
        return findByKilometerCarResponses;
    }

    @Override
    public List<GetAllCarResponses> findByPrice(double price) {
        List<Car> cars = carRepository.findByPrice(price);
        List<GetAllCarResponses> findByPriceCarResponses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarResponses.class))
                .collect(Collectors.toList());
        return findByPriceCarResponses;
    }

}
