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

/**
 * Service interface for managing car-related operations.
 * Defines methods for retrieving, adding, updating, and deleting cars.
 * Also includes methods for finding cars by year or plate.
 * Uses Data Transfer Objects (DTOs) for requests and responses.
 * Provides both individual and list-based retrieval of car information.
 * Supports CRUD (Create, Read, Update, Delete) operations for cars.
 *
 * @author [Harun Yılmaz]
 */

public interface CarService {
    DataResult<List<GetAllCarResponses>> getAll();

    DataResult<GetByIdCarResponses> getById(int id);

    Result add(CreateCarRequests createCarRequests);

    Result update(UpdateCarRequests updateCarRequests);

    Result delete(DeleteCarRequests deleteCarRequests);

    List<GetAllCarResponses> findByYear(int year);

    List<GetAllCarResponses> findByPlate(String plate);

    List<GetAllCarResponses> findByGearType(String gearType);

    List<GetAllCarResponses> findByKilometer(int kilometer);

    List<GetAllCarResponses> findByPrice(double price);

}
