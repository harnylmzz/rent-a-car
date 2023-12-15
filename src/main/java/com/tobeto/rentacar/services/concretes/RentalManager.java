package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.entities.Rental;
import com.tobeto.rentacar.repository.CarRepository;
import com.tobeto.rentacar.repository.RentalRepository;
import com.tobeto.rentacar.services.abstracts.RentalService;
import com.tobeto.rentacar.services.dtos.requests.rental.CreateRentalRequests;
import com.tobeto.rentacar.services.dtos.requests.rental.DeleteRentalRequests;
import com.tobeto.rentacar.services.dtos.requests.rental.UpdateRentalRequests;
import com.tobeto.rentacar.services.dtos.responses.rental.GetAllRentalResponses;
import com.tobeto.rentacar.services.dtos.responses.rental.GetByIdRentalResponses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private RentalRepository rentalRepository;
    private ModelMapperService modelMapperService;
    private CarRepository carRepository;

    @Override
    public List<GetAllRentalResponses> getAll() {
        List<Rental> rentals = rentalRepository.findAll();
        List<GetAllRentalResponses> getAllRentalResponses = rentals.stream()
                .map(rental -> this.modelMapperService.forResponse()
                        .map(rental, GetAllRentalResponses.class)).collect(Collectors.toList());
        return getAllRentalResponses;
    }

    @Override
    public GetByIdRentalResponses getById(int id) {
        Rental rental = rentalRepository.findById(id).orElseThrow();
        GetByIdRentalResponses getByIdRentalResponses = this.modelMapperService.forResponse()
                .map(rental, GetByIdRentalResponses.class);

        return getByIdRentalResponses;
    }

    @Override
    public void add(CreateRentalRequests createRentalRequests) {
        Rental rental = this.modelMapperService.forRequest().map(createRentalRequests, Rental.class);

        LocalDate today = LocalDate.now();
        if (rental.getStartDate().isBefore(today)) {
            throw new RuntimeException("Start date cannot be before today.");
        }

        if (rental.getEndDate().isBefore(rental.getStartDate())) {
            throw new RuntimeException("End date cannot be before the start date.");
        }

        if (rental.getReturnDate().isBefore(rental.getStartDate())) {
            throw new RuntimeException("Return date cannot be before the start date.");
        }

        // StartKilometer kiralanmak istenen aracın Kilometer alanından alınmalıdır.
        //  Car car = this.carRepository.findById(rental.getCar().getId()).get();
        //  rental.setStartKilometer(car.getKilometer());

        // ReturnDate null bırakılabilir

        rental.setReturnDate(null);

        this.rentalRepository.save(rental);

    }

    @Override
    public void update(UpdateRentalRequests updateRentalRequests) {
        Rental rental = this.modelMapperService.forRequest().map(updateRentalRequests, Rental.class);
        rental.setId(updateRentalRequests.getId());
        rental.setDiscount(updateRentalRequests.getDiscount());
        rental.setStartKilometer(updateRentalRequests.getStartKilometer());
        rental.setEndKilometer(updateRentalRequests.getEndKilometer());
        rental.setStartDate(updateRentalRequests.getStartDate());
        rental.setEndDate(updateRentalRequests.getEndDate());
        rental.setReturnDate(updateRentalRequests.getReturnDate());
        rental.setTotalPrice(updateRentalRequests.getTotalPrice());

        this.rentalRepository.save(rental);
    }

    @Override
    public void delete(DeleteRentalRequests deleteRentalRequests) {
        Rental rental = this.modelMapperService.forRequest().map(deleteRentalRequests, Rental.class);
        this.rentalRepository.delete(rental);

    }
}
