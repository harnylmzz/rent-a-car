package com.tobeto.rentacar.services.rules.fuelType;

import com.tobeto.rentacar.repository.FuelTypeRepository;
import com.tobeto.rentacar.services.messages.fuelType.FuelTypeMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FuelTypeBusinessRules {

    private final FuelTypeRepository fuelTypeRepository;
    public void checkIfFuelTypeExists(String type) {
        if (fuelTypeRepository.existsByFuelType(type)) {
            throw new RuntimeException(FuelTypeMessages.FUEL_TYPE_ALREADY_EXISTS);
        }
    }
}
