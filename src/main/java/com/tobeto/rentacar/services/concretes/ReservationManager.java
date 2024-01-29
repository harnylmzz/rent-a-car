package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.Reservation;
import com.tobeto.rentacar.repository.ReservationRepository;
import com.tobeto.rentacar.services.abstracts.ReservationService;
import com.tobeto.rentacar.services.dtos.requests.reservation.CreateReservationRequests;
import com.tobeto.rentacar.services.dtos.requests.reservation.DeleteReservationRequests;
import com.tobeto.rentacar.services.dtos.requests.reservation.UpdateReservationRequests;
import com.tobeto.rentacar.services.dtos.responses.reservation.GetAllReservationResponses;
import com.tobeto.rentacar.services.dtos.responses.reservation.GetByIdResevervationResponses;
import com.tobeto.rentacar.services.constans.reservation.ReservationMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationManager implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllReservationResponses>> getAll() {

        List<Reservation> reservations = this.reservationRepository.findAll();
        List<GetAllReservationResponses> getAllReservationResponses = reservations.stream()
                .map(reservation -> this.modelMapperService.forResponse()
                        .map(reservation, GetAllReservationResponses.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllReservationResponses, true, ReservationMessages.RESERVATIONS_LISTED);
    }

    @Override
    public DataResult<GetByIdResevervationResponses> getById(int id) {

        Reservation reservation = this.reservationRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(ReservationMessages.RESERVATION_NOT_FOUND));

        GetByIdResevervationResponses getByIdResevervationResponses = this.modelMapperService.forResponse()
                .map(reservation, GetByIdResevervationResponses.class);

        return new DataResult<>(getByIdResevervationResponses, true, ReservationMessages.RESERVATIONS_LISTED);
    }

    @Override
    public Result add(CreateReservationRequests createReservationRequests) {

        Reservation reservation = this.modelMapperService.forRequest()
                .map(createReservationRequests, Reservation.class);

        this.reservationRepository.save(reservation);

        return new SuccessResult(ReservationMessages.RESERVATION_ADDED);
    }

    @Override
    public Result update(UpdateReservationRequests updateReservationRequests) {

        Reservation reservation = this.modelMapperService.forRequest()
                .map(updateReservationRequests, Reservation.class);

        reservation.setId(updateReservationRequests.getId());
        reservation.setStartDate(updateReservationRequests.getStartDate());
        reservation.setEndDate(updateReservationRequests.getEndDate());
        reservation.setAdditionalServices(updateReservationRequests.getAdditionalServices());

        this.reservationRepository.save(reservation);

        return new SuccessResult(ReservationMessages.RESERVATION_UPDATED);
    }

    @Override
    public Result delete(DeleteReservationRequests deleteReservationRequests) {

        Reservation reservation = this.modelMapperService.forRequest()
                .map(deleteReservationRequests, Reservation.class);

        this.reservationRepository.delete(reservation);

        return new SuccessResult(ReservationMessages.RESERVATION_DELETED);
    }
}
