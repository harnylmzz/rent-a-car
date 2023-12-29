package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.entities.concretes.Car;
import com.tobeto.rentacar.services.dtos.requests.car.CreateCarRequests;
import com.tobeto.rentacar.services.dtos.requests.car.DeleteCarRequests;
import com.tobeto.rentacar.services.dtos.requests.car.UpdateCarRequests;
import com.tobeto.rentacar.services.dtos.responses.car.GetAllCarResponses;
import com.tobeto.rentacar.services.dtos.responses.car.GetByIdCarResponses;

import java.util.List;

public interface CarService {
    DataResult<List<GetAllCarResponses>> getAll();

    DataResult<GetByIdCarResponses> getById(int id);

    Result add(CreateCarRequests createCarRequests);

    Result update(UpdateCarRequests updateCarRequests);

    Result delete(DeleteCarRequests deleteCarRequests);

    boolean existsById(int id);

    List<GetAllCarResponses> findByYear(int year);

    List<GetAllCarResponses> findByKilometer(int kilometer);

    List<GetAllCarResponses> findByPrice(int price);



}
