package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.FuelType;
import com.tobeto.rentacar.repository.FuelTypeRepository;
import com.tobeto.rentacar.services.abstracts.FuelTypeService;
import com.tobeto.rentacar.services.dtos.requests.fuelType.CreateFuelTypeRequests;
import com.tobeto.rentacar.services.dtos.requests.fuelType.DeleteFuelTypeRequests;
import com.tobeto.rentacar.services.dtos.requests.fuelType.UpdateFuelTypeRequests;
import com.tobeto.rentacar.services.dtos.responses.fuelType.GetAllFuelTypeResponses;
import com.tobeto.rentacar.services.dtos.responses.fuelType.GetByIdFuelTypeResponses;
import com.tobeto.rentacar.services.constans.fuelType.FuelTypeMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class FuelTypeManager implements FuelTypeService {

    private final FuelTypeRepository fuelTypeRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllFuelTypeResponses>> getAll() {
        List<FuelType> fuelTypes = fuelTypeRepository.findAll();
        List<GetAllFuelTypeResponses> getAllFuelTypeResponses = fuelTypes.stream()
                .map(fuelType -> this.modelMapperService.forResponse()
                        .map(fuelType, GetAllFuelTypeResponses.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllFuelTypeResponses, true, FuelTypeMessages.FUEL_TYPES_LISTED);
    }

    @Override
    public DataResult<GetByIdFuelTypeResponses> getById(int id) {
        FuelType fuelType = fuelTypeRepository.findById(id).orElseThrow(() -> new DataNotFoundException(FuelTypeMessages.FUEL_TYPE_NOT_FOUND));
        GetByIdFuelTypeResponses getByIdFuelTypeResponses = this.modelMapperService.forResponse()
                .map(fuelType, GetByIdFuelTypeResponses.class);

        return new DataResult<>(getByIdFuelTypeResponses, true, FuelTypeMessages.FUEL_TYPES_LISTED);
    }

    @Override
    public Result add(CreateFuelTypeRequests createFuelTypeRequests) {

        FuelType fuelType = this.modelMapperService.forRequest()
                .map(createFuelTypeRequests, FuelType.class);
        this.fuelTypeRepository.save(fuelType);

        return new SuccessResult(FuelTypeMessages.FUEL_TYPE_ADDED);
    }

    @Override
    public Result update(UpdateFuelTypeRequests updateFuelTypeRequests) {
        FuelType fuelType = this.modelMapperService.forRequest()
                .map(updateFuelTypeRequests, FuelType.class);
        this.fuelTypeRepository.save(fuelType);

        return new SuccessResult(FuelTypeMessages.FUEL_TYPE_UPDATED);

    }

    @Override
    public Result delete(DeleteFuelTypeRequests deleteFuelTypeRequests) {
        FuelType fuelType = this.modelMapperService.forRequest()
                .map(deleteFuelTypeRequests, FuelType.class);
        this.fuelTypeRepository.delete(fuelType);

        return new SuccessResult(FuelTypeMessages.FUEL_TYPE_DELETED);

    }
}
