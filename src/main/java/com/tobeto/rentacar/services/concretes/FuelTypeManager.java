package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.entities.concretes.FuelType;
import com.tobeto.rentacar.repository.FuelTypeRepository;
import com.tobeto.rentacar.services.abstracts.FuelTypeService;
import com.tobeto.rentacar.services.dtos.requests.fuelType.CreateFuelTypeRequests;
import com.tobeto.rentacar.services.dtos.requests.fuelType.DeleteFuelTypeRequests;
import com.tobeto.rentacar.services.dtos.requests.fuelType.UpdateFuelTypeRequests;
import com.tobeto.rentacar.services.dtos.responses.fuelType.GetAllFuelTypeResponses;
import com.tobeto.rentacar.services.dtos.responses.fuelType.GetByIdFuelTypeResponses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FuelTypeManager implements FuelTypeService {
    private FuelTypeRepository fuelTypeRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllFuelTypeResponses> getAll() {
        List<FuelType> fuelTypes = fuelTypeRepository.findAll();
        List<GetAllFuelTypeResponses> getAllFuelTypeResponses = fuelTypes.stream()
                .map(fuelType -> this.modelMapperService.forResponse()
                        .map(fuelType, GetAllFuelTypeResponses.class))
                .collect(Collectors.toList());

        return getAllFuelTypeResponses;
    }
    @Override
    public GetByIdFuelTypeResponses getById(int id) {
        FuelType fuelType = fuelTypeRepository.findById(id).orElseThrow();
        GetByIdFuelTypeResponses getByIdFuelTypeResponses = this.modelMapperService.forResponse()
                .map(fuelType, GetByIdFuelTypeResponses.class);

        return getByIdFuelTypeResponses;
    }

    @Override
    public void add(CreateFuelTypeRequests createFuelTypeRequests) {
        FuelType fuelType = this.modelMapperService.forRequest()
                .map(createFuelTypeRequests, FuelType.class);
        this.fuelTypeRepository.save(fuelType);
    }

    @Override
    public void update(UpdateFuelTypeRequests updateFuelTypeRequests) {
        FuelType fuelType = this.modelMapperService.forRequest()
                .map(updateFuelTypeRequests, FuelType.class);
        this.fuelTypeRepository.save(fuelType);

    }

    @Override
    public void delete(DeleteFuelTypeRequests deleteFuelTypeRequests) {
        FuelType fuelType = this.modelMapperService.forRequest()
                .map(deleteFuelTypeRequests, FuelType.class);
        this.fuelTypeRepository.delete(fuelType);

    }
}
