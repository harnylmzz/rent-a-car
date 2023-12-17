package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.core.exceptions.BusinessException;
import com.tobeto.rentacar.entities.Car;
import com.tobeto.rentacar.services.dtos.requests.rental.CreateRentalRequests;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class RentalBusinessRules {
    private static final int MAXIMUM_RENTAL_DAYS = 25;

    public void checkIfDailyPrice(CreateRentalRequests createRentalRequests) {


    }

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

        long rentalDays = createRentalRequests.getStartDate().until(createRentalRequests.getEndDate()).getDays();
        if (rentalDays > MAXIMUM_RENTAL_DAYS) {
            throw new BusinessException("The rental duration cannot exceed 25 days.");
        }
    }
}
