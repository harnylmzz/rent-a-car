package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.core.exceptions.BusinessException;
import com.tobeto.rentacar.repository.CarRepository;
import com.tobeto.rentacar.services.dtos.requests.car.CreateCarRequests;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarBusinessRules {

    private CarRepository carRepository;

    public void checkIfPlate(String plate) {
        if (this.carRepository.existsByPlate(plate)) {
            throw new BusinessException("Plate already exists");
        }
    }

    public void checkIfKilometer(CreateCarRequests createCarRequests) {
        if (createCarRequests.getKilometer() < 0) {
            throw new BusinessException("Kilometer field cannot be less than 0!");
        }
    }

    public void checkIfYear(CreateCarRequests createCarRequests) {
        int year = createCarRequests.getYear();
        if (year < 2005 || year > 2024) {
            throw new BusinessException("Year information should be between 2005 and 2024.");
        }
    }

    public void checkIfPrice(CreateCarRequests createCarRequests) {
        if (createCarRequests.getPrice() < 0) {
            throw new BusinessException("DailyPrice cannot be less than 0.");
        }
    }

}
