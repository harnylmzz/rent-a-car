package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
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
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;
    private ColorRepository colorRepository;
    private ModelRepository modelRepository;

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
    public void add(CreateCarRequests createCarRequests) {
        Car addCar = new Car();
        String plate = createCarRequests.getPlate().replace(" ", ""); // Boşlukları kaldır

        if (this.carRepository.existsByPlate(plate)) {
            throw new RuntimeException("Car with this plate already exists!");
        }

        Car car = this.modelMapperService.forRequest()
                .map(createCarRequests, Car.class);

        car.setPlate(plate); // Düzenlenmiş plakayı araca ata

        if (car.getKilometer() < 0) {
            throw new RuntimeException("Kilometer field cannot be less than 0!");
        }

        int year = car.getYear();
        if (year < 2005 || year > 2024) {
            throw new RuntimeException("Year information should be between 2005 and 2024.");
        }

        if (car.getPrice() < 0) {
            throw new RuntimeException("DailyPrice cannot be less than 0.");
        }

        // Veritabanından model ve renk nesnelerini al
        Model model = modelRepository.findById(createCarRequests.getModelId())
                .orElseThrow(() -> new RuntimeException("Model not found"));

        Color color = colorRepository.findById(createCarRequests.getColorId())
                .orElseThrow(() -> new RuntimeException("Color not found"));

        // Arabaya model ve renk nesnelerini ata
        car.setModel(model);
        car.setColor(color);

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
