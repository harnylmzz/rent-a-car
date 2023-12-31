package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.core.exceptions.BusinessException;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.entities.concretes.Customer;
import com.tobeto.rentacar.entities.concretes.Employee;
import com.tobeto.rentacar.repository.CustomerRepository;
import com.tobeto.rentacar.repository.EmployeeRepository;
import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.abstracts.EmployeeService;
import com.tobeto.rentacar.services.dtos.requests.rental.CreateRentalRequests;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class RentalBusinessRules {

    private CarService carService;
    private EmployeeService employeeService;
    private CustomerService customerService;
    private CustomerRepository customerRepository;
    private EmployeeRepository employeeRepository;

    private static final int MAXIMUM_RENTAL_DAYS = 25;


    public void checkIfDate(CreateRentalRequests createRentalRequests) {

        LocalDate today = LocalDate.now();

        if (createRentalRequests.getStartDate().isBefore(today)) {
            throw new BusinessException("Start date cannot be before today.");
        }

        if (createRentalRequests.getEndDate().isBefore(createRentalRequests.getStartDate())) {
            throw new BusinessException("End date cannot be before the start date.");
        }

        if (createRentalRequests.getReturnDate().isBefore(createRentalRequests.getStartDate())) {
            throw new BusinessException("Return date cannot be before the start date.");
        }

        LocalDate startDate = createRentalRequests.getStartDate();
        LocalDate endDate = createRentalRequests.getEndDate();

        if (startDate.plusDays(MAXIMUM_RENTAL_DAYS).isBefore(endDate)) {
            throw new BusinessException("The rental duration cannot exceed 25 days.");
        }
    }
}


