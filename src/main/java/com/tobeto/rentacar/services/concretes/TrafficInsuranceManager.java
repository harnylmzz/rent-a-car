package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.TrafficInsurance;
import com.tobeto.rentacar.repository.TrafficInsuranceRepository;
import com.tobeto.rentacar.services.abstracts.TrafficInsuranceService;
import com.tobeto.rentacar.services.constans.trafficInsurance.TrafficInsuranceMessages;
import com.tobeto.rentacar.services.dtos.requests.trafficInsurance.CreateTrafficInsuranceRequests;
import com.tobeto.rentacar.services.dtos.requests.trafficInsurance.DeleteTrafficInsuranceRequests;
import com.tobeto.rentacar.services.dtos.requests.trafficInsurance.UpdateTrafficInsuranceRequests;
import com.tobeto.rentacar.services.dtos.responses.trafficInsurance.GetAllTrafficInsuranceResponses;
import com.tobeto.rentacar.services.dtos.responses.trafficInsurance.GetByIdTrafficInsuranceResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrafficInsuranceManager implements TrafficInsuranceService {

    private final TrafficInsuranceRepository trafficInsuranceRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllTrafficInsuranceResponses>> getAll() {

        List<TrafficInsurance> trafficInsurances = this.trafficInsuranceRepository.findAll();
        List<GetAllTrafficInsuranceResponses> getAllTrafficInsuranceResponses = trafficInsurances.stream()
                .map(trafficInsurance -> this.modelMapperService.forResponse()
                        .map(trafficInsurance, GetAllTrafficInsuranceResponses.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllTrafficInsuranceResponses, true, TrafficInsuranceMessages.TRAFFIC_INSURANCES_LISTED);
    }

    @Override
    public DataResult<GetByIdTrafficInsuranceResponses> getById(int id) {

        TrafficInsurance trafficInsurance = this.trafficInsuranceRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Data not found."));

        GetByIdTrafficInsuranceResponses getByIdTrafficInsuranceResponses = this.modelMapperService.forResponse()
                .map(trafficInsurance, GetByIdTrafficInsuranceResponses.class);

        return new DataResult<>(getByIdTrafficInsuranceResponses, true, new TrafficInsuranceMessages.TRAFFIC_INSURANCES_LISTED);
    }

    @Override
    public Result add(CreateTrafficInsuranceRequests createTrafficInsuranceRequests) {

        TrafficInsurance trafficInsurance = this.modelMapperService.forRequest()
                .map(createTrafficInsuranceRequests, TrafficInsurance.class);

        this.trafficInsuranceRepository.save(trafficInsurance);

        return new SuccessResult(TrafficInsuranceMessages.TRAFFIC_INSURANCE_ADDED);
    }

    @Override
    public Result update(UpdateTrafficInsuranceRequests updateTrafficInsuranceRequests) {

        TrafficInsurance trafficInsurance = this.modelMapperService.forRequest()
                .map(updateTrafficInsuranceRequests, TrafficInsurance.class);

        trafficInsurance.setId(updateTrafficInsuranceRequests.getId());
        trafficInsurance.setDeductibleAmount(updateTrafficInsuranceRequests.getDeductibleAmount());

        this.trafficInsuranceRepository.save(trafficInsurance);

        return new SuccessResult(TrafficInsuranceMessages.TRAFFIC_INSURANCE_UPDATED);
    }

    @Override
    public Result delete(DeleteTrafficInsuranceRequests deleteTrafficInsuranceRequests) {

        TrafficInsurance trafficInsurance = this.modelMapperService.forRequest()
                .map(deleteTrafficInsuranceRequests, TrafficInsurance.class);

        this.trafficInsuranceRepository.delete(trafficInsurance);

        return new SuccessResult(TrafficInsuranceMessages.TRAFFIC_INSURANCE_DELETED);
    }
}
