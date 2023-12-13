package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.repository.CarRepository;
import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.dtos.requests.car.CreateCarRequests;
import com.tobeto.rentacar.services.dtos.requests.car.DeleteCarRequests;
import com.tobeto.rentacar.services.dtos.requests.car.UpdateCarRequests;
import com.tobeto.rentacar.services.dtos.responses.car.GetAllCarResponses;
import com.tobeto.rentacar.services.dtos.responses.car.GetByIdCarResponses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllCarResponses> getAll() {
        return null;
    }

    @Override
    public GetByIdCarResponses getById(int id) {
        return null;
    }

    @Override
    public void add(CreateCarRequests createBrandRequests) {

    }

    @Override
    public void update(UpdateCarRequests updateCarRequests) {

    }

    @Override
    public void delete(DeleteCarRequests deleteCarRequests) {

    }
}
