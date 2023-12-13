package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.requests.car.CreateCarRequests;
import com.tobeto.rentacar.services.dtos.requests.car.DeleteCarRequests;
import com.tobeto.rentacar.services.dtos.requests.car.UpdateCarRequests;
import com.tobeto.rentacar.services.dtos.responses.car.GetAllCarResponses;
import com.tobeto.rentacar.services.dtos.responses.car.GetByIdCarResponses;

import java.util.List;

public interface CarService {
    List<GetAllCarResponses> getAll();
    GetByIdCarResponses getById(int id);
    void add(CreateCarRequests createBrandRequests);
    void update(UpdateCarRequests updateCarRequests);
    void delete(DeleteCarRequests deleteCarRequests);

}
