package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.requests.fuelType.CreateFuelTypeRequests;
import com.tobeto.rentacar.services.dtos.requests.fuelType.DeleteFuelTypeRequests;
import com.tobeto.rentacar.services.dtos.requests.fuelType.UpdateFuelTypeRequests;
import com.tobeto.rentacar.services.dtos.responses.fuelType.GetAllFuelTypeResponses;
import com.tobeto.rentacar.services.dtos.responses.fuelType.GetByIdFuelTypeResponses;

import java.util.List;

public interface FuelTypeService {
    List<GetAllFuelTypeResponses> getAll();
    GetByIdFuelTypeResponses getById(int id);
    void add(CreateFuelTypeRequests createFuelTypeRequests);
    void update(UpdateFuelTypeRequests updateFuelTypeRequests);
    void delete(DeleteFuelTypeRequests deleteFuelTypeRequests);
}
