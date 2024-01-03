package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.entities.concretes.Rental;
import com.tobeto.rentacar.services.dtos.requests.rental.CreateRentalRequests;
import com.tobeto.rentacar.services.dtos.requests.rental.DeleteRentalRequests;
import com.tobeto.rentacar.services.dtos.requests.rental.UpdateRentalRequests;
import com.tobeto.rentacar.services.dtos.responses.rental.GetAllRentalResponses;
import com.tobeto.rentacar.services.dtos.responses.rental.GetByIdRentalResponses;

import java.time.LocalDate;
import java.util.List;

public interface RentalService {
    DataResult<List<GetAllRentalResponses>> getAll();
    DataResult<GetByIdRentalResponses> getById(int id);
    Result add(CreateRentalRequests createRentalRequests);
    Result update(UpdateRentalRequests updateRentalRequests);
    Result delete(DeleteRentalRequests deleteRentalRequests);

    List<GetAllRentalResponses> findByStartDate(LocalDate startDate);

    List<GetAllRentalResponses> findByEndDate(LocalDate endDate);

    List<GetAllRentalResponses> findByReturnDate(LocalDate returnDate);

    List<GetAllRentalResponses> findByStartKilometer(int startKilometer);

    List<GetAllRentalResponses> findByEndKilometer(int endKilometer);

    List<GetAllRentalResponses> findByTotalPrice(double totalPrice);

    List<GetAllRentalResponses> findByDiscount(double discount);


}
