package com.tobeto.rentacar.services.rules.rental;

import com.tobeto.rentacar.core.exceptions.BusinessException;
import com.tobeto.rentacar.repository.CustomerRepository;
import com.tobeto.rentacar.repository.EmployeeRepository;
import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.abstracts.EmployeeService;
import com.tobeto.rentacar.services.constans.rental.RentalMessages;
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
            throw new BusinessException(RentalMessages.START_DATE_CANNOT_BE_BEFORE_TODAY);
        }

        if (createRentalRequests.getEndDate().isBefore(createRentalRequests.getStartDate())) {
            throw new BusinessException(RentalMessages.END_DATE_CANNOT_BE_BEFORE_THE_START_DATE);
        }

        if (createRentalRequests.getReturnDate().isBefore(createRentalRequests.getStartDate())) {
            throw new BusinessException(RentalMessages.RETURN_DATE_CANNOT_BE_BEFORE_THE_START_DATE);
        }

        LocalDate startDate = createRentalRequests.getStartDate();
        LocalDate endDate = createRentalRequests.getEndDate();

        if (startDate.plusDays(MAXIMUM_RENTAL_DAYS).isBefore(endDate)) {
            throw new BusinessException(RentalMessages.THE_RENTAL_DURATION_CANNOT_EXCEED_25_DAYS);
        }
    }
}


