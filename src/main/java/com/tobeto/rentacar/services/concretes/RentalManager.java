package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;

import com.tobeto.rentacar.entities.concretes.*;

import com.tobeto.rentacar.repository.*;

import com.tobeto.rentacar.services.abstracts.RentalService;
import com.tobeto.rentacar.services.dtos.requests.rental.CreateRentalRequests;
import com.tobeto.rentacar.services.dtos.requests.rental.DeleteRentalRequests;
import com.tobeto.rentacar.services.dtos.requests.rental.UpdateRentalRequests;
import com.tobeto.rentacar.services.dtos.responses.rental.GetAllRentalResponses;
import com.tobeto.rentacar.services.dtos.responses.rental.GetByIdRentalResponses;
import com.tobeto.rentacar.services.rules.RentalBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.ClientInfoStatus;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private RentalRepository rentalRepository;
    private ModelMapperService modelMapperService;
    private CarRepository carRepository;
    private RentalBusinessRules rentalBusinessRules;
    private CustomerRepository customerRepository;
    private EmployeeRepository employeeRepository;

    @Override
    public DataResult<List<GetAllRentalResponses>> getAll() {
        List<Rental> rentals = rentalRepository.findAll();
        List<GetAllRentalResponses> getAllRentalResponses = rentals.stream()
                .map(rental -> this.modelMapperService.forResponse()
                        .map(rental, GetAllRentalResponses.class)).collect(Collectors.toList());
        return new DataResult<>(getAllRentalResponses, true, "Rentals listed");
    }

    @Override
    public DataResult<GetByIdRentalResponses> getById(int id) {

        Rental rental = rentalRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Data not found.") {
        });
        GetByIdRentalResponses getByIdRentalResponses = this.modelMapperService.forResponse()
                .map(rental, GetByIdRentalResponses.class);

        return new DataResult<>(getByIdRentalResponses, true, "Rental listed");
    }

    @Override
    public Result add(CreateRentalRequests createRentalRequests) {

        this.rentalBusinessRules.checkIfDate(createRentalRequests);

        Rental rental = this.modelMapperService.forRequest()
                .map(createRentalRequests, Rental.class);

        Car car = this.carRepository.findById(createRentalRequests.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found"));

        Employee employee = this.employeeRepository.findById(createRentalRequests.getEmployeeId())
                .orElse(null);

        Customer customer = this.customerRepository.findById(createRentalRequests.getCustomerId())
                .orElse(null);

        rental.setCar(car);
        rental.setEmployee(employee);
        rental.setCustomer(customer);

        int rentalLimit = rental.getStartDate().until(rental.getEndDate()).getDays() + 1;
        rental.setTotalPrice(car.getPrice() * rentalLimit);

        this.rentalRepository.save(rental);

        return new SuccessResult("Rental added");
    }

    @Override
    public Result update(UpdateRentalRequests updateRentalRequests) {
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

        return new SuccessResult("Rental updated");
    }

    @Override
    public Result delete(DeleteRentalRequests deleteRentalRequests) {
        Rental rental = this.modelMapperService.forRequest().map(deleteRentalRequests, Rental.class);
        this.rentalRepository.delete(rental);

        return new SuccessResult("Rental deleted");
    }

    @Override
    public List<GetAllRentalResponses> findByStartDate(LocalDate startDate) {
        List<Rental> rentals = rentalRepository.findByStartDate(startDate);
        List<GetAllRentalResponses> responsesList = new ArrayList<>();

        for (Rental rental : rentals ) {
            responsesList.add(new GetAllRentalResponses(rental.getStartDate()));
        }
        return responsesList;
    }

    @Override
    public List<GetAllRentalResponses> findByEndDate(LocalDate endDate) {
        List<Rental> rentals = rentalRepository.findByEndDate(endDate);
        List<GetAllRentalResponses> responsesList = new ArrayList<>();

        for (Rental rental : rentals ) {
            responsesList.add(new GetAllRentalResponses(rental.getEndDate()));
        }
        return responsesList;
    }

    @Override
    public List<GetAllRentalResponses> findByReturnDate(LocalDate returnDate) {
        List<Rental> rentals = rentalRepository.findByReturnDate(returnDate);
        List<GetAllRentalResponses> responsesList = new ArrayList<>();

        for (Rental rental : rentals ) {
            responsesList.add(new GetAllRentalResponses(rental.getReturnDate()));
        }
        return responsesList;
    }

    @Override
    public List<GetAllRentalResponses> findByStartKilometer(int startKilometer) {
        List<Rental> rentals = rentalRepository.findByStartKilometer(startKilometer);
        List<GetAllRentalResponses> responsesList = new ArrayList<>();

        for (Rental rental : rentals ) {
            responsesList.add(new GetAllRentalResponses(rental.getStartKilometer()));
        }
        return responsesList;
    }

    @Override
    public List<GetAllRentalResponses> findByEndKilometer(int endKilometer) {
        List<Rental> rentals = rentalRepository.findByEndKilometer(endKilometer);
        List<GetAllRentalResponses> responsesList = new ArrayList<>();

        for (Rental rental : rentals ) {
            responsesList.add(new GetAllRentalResponses(rental.getEndKilometer()));
        }
        return responsesList;
    }

    @Override
    public List<GetAllRentalResponses> findByTotalPrice(double totalPrice) {
        List<Rental> rentals = rentalRepository.findByTotalPrice(totalPrice);
        List<GetAllRentalResponses> responsesList = new ArrayList<>();

        for (Rental rental : rentals ) {
            responsesList.add(new GetAllRentalResponses(rental.getTotalPrice()));
        }
        return responsesList;
    }

    @Override
    public List<GetAllRentalResponses> findByDiscount(double discount) {
       List<Rental> rentals = rentalRepository.findByDiscount(discount);
       List<GetAllRentalResponses> responsesList = new ArrayList<>();

       for(Rental rental : rentals ) {
           responsesList.add(new GetAllRentalResponses(rental.getDiscount()));
       }
       return responsesList;
    }
}
