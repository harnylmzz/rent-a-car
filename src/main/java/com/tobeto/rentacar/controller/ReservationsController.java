package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.ReservationService;
import com.tobeto.rentacar.services.dtos.requests.reservation.CreateReservationRequests;
import com.tobeto.rentacar.services.dtos.requests.reservation.DeleteReservationRequests;
import com.tobeto.rentacar.services.dtos.requests.reservation.UpdateReservationRequests;
import com.tobeto.rentacar.services.dtos.responses.reservation.GetAllReservationResponses;
import com.tobeto.rentacar.services.dtos.responses.reservation.GetByIdResevervationResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservations")
@RequiredArgsConstructor
public class ReservationsController {

    private final ReservationService reservationService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllReservationResponses>> getAll() {
        return this.reservationService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdResevervationResponses> getById(int id) {
        return this.reservationService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateReservationRequests createReservationRequests) {
        return this.reservationService.add(createReservationRequests);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateReservationRequests updateReservationRequests) {
        return this.reservationService.update(updateReservationRequests);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteReservationRequests deleteReservationRequests) {
        return this.reservationService.delete(deleteReservationRequests);
    }
}
