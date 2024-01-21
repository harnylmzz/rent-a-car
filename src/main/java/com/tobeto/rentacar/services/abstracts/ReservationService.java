package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.dtos.requests.reservation.CreateReservationRequests;
import com.tobeto.rentacar.services.dtos.requests.reservation.DeleteReservationRequests;
import com.tobeto.rentacar.services.dtos.requests.reservation.UpdateReservationRequests;
import com.tobeto.rentacar.services.dtos.responses.reservation.GetAllReservationResponses;
import com.tobeto.rentacar.services.dtos.responses.reservation.GetByIdResevervationResponses;

import java.util.List;

public interface ReservationService {

    DataResult<List<GetAllReservationResponses>> getAll();

    DataResult<GetByIdResevervationResponses> getById(int id);

    Result add(CreateReservationRequests createReservationRequests);

    Result update(UpdateReservationRequests updateReservationRequests);

    Result delete(DeleteReservationRequests deleteReservationRequests);
}
