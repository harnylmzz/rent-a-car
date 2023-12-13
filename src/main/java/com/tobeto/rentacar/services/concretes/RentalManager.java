package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.repository.RentalRepository;
import com.tobeto.rentacar.services.abstracts.RentalService;
import com.tobeto.rentacar.services.dtos.requests.rental.CreateRentalRequests;
import com.tobeto.rentacar.services.dtos.requests.rental.DeleteRentalRequests;
import com.tobeto.rentacar.services.dtos.requests.rental.UpdateRentalRequests;
import com.tobeto.rentacar.services.dtos.responses.rental.GetAllRentalResponses;
import com.tobeto.rentacar.services.dtos.responses.rental.GetByIdRentalResponses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private RentalRepository rentalRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllRentalResponses> getAll() {
        return null;
    }

    @Override
    public GetByIdRentalResponses getById(int id) {
        return null;
    }

    @Override
    public void add(CreateRentalRequests createRentalRequests) {

    }

    @Override
    public void update(UpdateRentalRequests updateRentalRequests) {

    }

    @Override
    public void delete(DeleteRentalRequests deleteRentalRequests) {

    }
}
