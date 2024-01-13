package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.Insurance;
import com.tobeto.rentacar.repository.InsuranceRepository;
import com.tobeto.rentacar.services.abstracts.InsuranceService;
import com.tobeto.rentacar.services.dtos.requests.insurance.CreateInsuranceRequests;
import com.tobeto.rentacar.services.dtos.requests.insurance.DeleteInsuranceRequests;
import com.tobeto.rentacar.services.dtos.requests.insurance.UpdateInsuranceRequests;
import com.tobeto.rentacar.services.dtos.responses.insurance.GetAllInsuranceResponses;
import com.tobeto.rentacar.services.dtos.responses.insurance.GetByIdInsuranceResponses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InsuranceManager implements InsuranceService {

    private InsuranceRepository insuranceRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllInsuranceResponses>> getAll() {

        List<Insurance> insurances = insuranceRepository.findAll();
        List<GetAllInsuranceResponses> getAllInsuranceResponses = insurances.stream()
                .map(insurance -> modelMapperService.forResponse()
                        .map(insurance, GetAllInsuranceResponses.class))
                .collect(Collectors.toList());
        return new DataResult<>(getAllInsuranceResponses, true, "All insurances listed.");
    }

    @Override
    public DataResult<GetByIdInsuranceResponses> getById(int id) {

        Insurance insurance = insuranceRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Insurance not found."));

        GetByIdInsuranceResponses getByIdInsuranceResponses = modelMapperService.forResponse()
                .map(insurance, GetByIdInsuranceResponses.class);

        return new DataResult<>(getByIdInsuranceResponses, true, "Insurance listed.");
    }

    @Override
    public Result add(CreateInsuranceRequests createInsuranceRequests) {

        Insurance insurance = modelMapperService.forRequest()
                .map(createInsuranceRequests, Insurance.class);

        insuranceRepository.save(insurance);
        return new SuccessResult("Insurance added.");
    }

    @Override
    public Result update(UpdateInsuranceRequests updateInsuranceRequests) {

        Insurance insurance = modelMapperService.forRequest()
                .map(updateInsuranceRequests, Insurance.class);

        insurance.setId(updateInsuranceRequests.getId());
        insurance.setStartDate(updateInsuranceRequests.getStartDate());
        insurance.setEndDate(updateInsuranceRequests.getEndDate());
        insurance.setPolicyNumber(updateInsuranceRequests.getPolicyNumber());

        insuranceRepository.save(insurance);

        return new SuccessResult("Insurance updated.");
    }

    @Override
    public Result delete(DeleteInsuranceRequests deleteInsuranceRequests) {

        Insurance insurance = modelMapperService.forRequest()
                .map(deleteInsuranceRequests, Insurance.class);

        insuranceRepository.delete(insurance);

        return new SuccessResult("Insurance deleted.");
    }
}
