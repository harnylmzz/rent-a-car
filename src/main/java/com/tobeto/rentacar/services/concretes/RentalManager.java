package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.entities.*;

import com.tobeto.rentacar.entities.Rental;
import com.tobeto.rentacar.repository.CarRepository;
import com.tobeto.rentacar.repository.CustomerRepository;
import com.tobeto.rentacar.repository.EmployeeRepository;
import com.tobeto.rentacar.repository.RentalRepository;

import com.tobeto.rentacar.services.abstracts.RentalService;
import com.tobeto.rentacar.services.dtos.requests.rental.CreateRentalRequests;
import com.tobeto.rentacar.services.dtos.requests.rental.DeleteRentalRequests;
import com.tobeto.rentacar.services.dtos.requests.rental.UpdateRentalRequests;
import com.tobeto.rentacar.services.dtos.responses.rental.GetAllRentalResponses;
import com.tobeto.rentacar.services.dtos.responses.rental.GetByIdRentalResponses;
import com.tobeto.rentacar.services.rules.RentalBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

        this.rentalBusinessRules.checkIfDate(createRentalRequests);

        Rental rental = this.modelMapperService.forRequest()
                .map(createRentalRequests, Rental.class);

        Car car = this.carRepository.findById(createRentalRequests.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found"));

        Customer customer = this.customerRepository.findById(createRentalRequests.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Employee employee = this.employeeRepository.findById(createRentalRequests.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        int startKilometer = car.getKilometer();
        rental.setStartKilometer(startKilometer);

        rental.setCar(car);
        rental.setCustomer(customer);
        rental.setEmployee(employee);
        rental.setReturnDate(null);
        // rental.setEndKilometer(null);

        int rentalLimit = rental.getStartDate().until(rental.getEndDate()).getDays() + 1;
        rental.setTotalPrice(car.getPrice() * rentalLimit);

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
