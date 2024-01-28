package com.tobeto.rentacar.services.rules.car;

import com.tobeto.rentacar.core.exceptions.BusinessException;
import com.tobeto.rentacar.repository.CarRepository;
import com.tobeto.rentacar.services.dtos.requests.car.CreateCarRequests;
import com.tobeto.rentacar.services.messages.car.CarMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarBusinessRules {

    private CarRepository carRepository;

    public void checkIfPlate(String plate) {
        if (this.carRepository.existsByPlate(plate)) {
            throw new BusinessException(CarMessages.PLATE_ALREADY_EXISTS);
        }
    }

    public void checkIfKilometer(CreateCarRequests createCarRequests) {
        if (createCarRequests.getKilometer() < 0) {
            throw new BusinessException(CarMessages.KILOMETER_FIELD_CANNOT_BE_LESS_THAN_ZERO);
        }
    }

    public void checkIfYear(CreateCarRequests createCarRequests) {
        int year = createCarRequests.getYear();
        if (year < 2005 || year > 2024) {
            throw new BusinessException(CarMessages.YEAR_INFORMATION_SHOULD_BE_BETWEEN_2005_AND_2024);
        }
    }

    public void checkIfPrice(CreateCarRequests createCarRequests) {
        if (createCarRequests.getPrice() < 0) {
            throw new BusinessException(CarMessages.DAILY_PRICE_CANNOT_BE_LESS_THAN_ZERO);
        }
    }
}
