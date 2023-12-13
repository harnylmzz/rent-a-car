package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.requests.rental.CreateRentalRequests;
import com.tobeto.rentacar.services.dtos.requests.rental.DeleteRentalRequests;
import com.tobeto.rentacar.services.dtos.requests.rental.UpdateRentalRequests;
import com.tobeto.rentacar.services.dtos.responses.rental.GetAllRentalResponses;
import com.tobeto.rentacar.services.dtos.responses.rental.GetByIdRentalResponses;

import java.util.List;

public interface RentalService {
    List<GetAllRentalResponses> getAll();
    GetByIdRentalResponses getById(int id);
    void add(CreateRentalRequests createRentalRequests);
    void update(UpdateRentalRequests updateRentalRequests);
    void delete(DeleteRentalRequests deleteRentalRequests);
}
