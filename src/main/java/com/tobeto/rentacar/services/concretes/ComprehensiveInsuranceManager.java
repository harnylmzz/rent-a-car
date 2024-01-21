package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.ComprehensiveInsurance;
import com.tobeto.rentacar.repository.ComprehensiveInsuranceRepository;
import com.tobeto.rentacar.services.abstracts.ComprehensiveInsuranceService;
import com.tobeto.rentacar.services.dtos.requests.comprehensiveInsurance.CreateComprehensiveInsuranceRequests;
import com.tobeto.rentacar.services.dtos.requests.comprehensiveInsurance.DeleteComprehensiveInsuranceRequests;
import com.tobeto.rentacar.services.dtos.requests.comprehensiveInsurance.UpdateComprehensiveInsuranceRequests;
import com.tobeto.rentacar.services.dtos.responses.comprehensiveInsurance.GetAllComprehensiveInsurance;
import com.tobeto.rentacar.services.dtos.responses.comprehensiveInsurance.GetByIdComprehensiveInsurance;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComprehensiveInsuranceManager implements ComprehensiveInsuranceService {

    private final ComprehensiveInsuranceRepository comprehensiveInsuranceRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllComprehensiveInsurance>> getAll() {

        List<ComprehensiveInsurance> comprehensiveInsurances = comprehensiveInsuranceRepository.findAll();
        List<GetAllComprehensiveInsurance> getAllComprehensiveInsurances = comprehensiveInsurances.stream()
                .map(comprehensiveInsurance -> this.modelMapperService.forResponse()
                        .map(comprehensiveInsurance, GetAllComprehensiveInsurance.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllComprehensiveInsurances, true, "Comprehensive Insurances listed");
    }

    @Override
    public DataResult<GetByIdComprehensiveInsurance> getById(int id) {

        ComprehensiveInsurance comprehensiveInsurance = comprehensiveInsuranceRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Data not found."));

        GetByIdComprehensiveInsurance getByIdComprehensiveInsurance = this.modelMapperService.forResponse()
                .map(comprehensiveInsurance, GetByIdComprehensiveInsurance.class);

        return new DataResult<>(getByIdComprehensiveInsurance, true, "Comprehensive Insurance listed");
    }

    @Override
    public Result add(CreateComprehensiveInsuranceRequests createComprehensiveInsuranceRequests) {

        ComprehensiveInsurance comprehensiveInsurance = this.modelMapperService.forRequest()
                .map(createComprehensiveInsuranceRequests, ComprehensiveInsurance.class);

        this.comprehensiveInsuranceRepository.save(comprehensiveInsurance);
        return new SuccessResult("Comprehensive Insurance added");
    }

    @Override
    public Result update(UpdateComprehensiveInsuranceRequests updateComprehensiveInsuranceRequests) {

        ComprehensiveInsurance comprehensiveInsurance = this.modelMapperService.forRequest()
                .map(updateComprehensiveInsuranceRequests, ComprehensiveInsurance.class);

        comprehensiveInsurance.setId(updateComprehensiveInsuranceRequests.getId());
        comprehensiveInsurance.setDeductibleAmount(updateComprehensiveInsuranceRequests.getDeductibleAmount());

        this.comprehensiveInsuranceRepository.save(comprehensiveInsurance);
        return new SuccessResult("Comprehensive Insurance updated");
    }

    @Override
    public Result delete(DeleteComprehensiveInsuranceRequests deleteComprehensiveInsuranceRequests) {

        ComprehensiveInsurance comprehensiveInsurance = this.modelMapperService.forRequest()
                .map(deleteComprehensiveInsuranceRequests, ComprehensiveInsurance.class);

        this.comprehensiveInsuranceRepository.delete(comprehensiveInsurance);
        return new SuccessResult("Comprehensive Insurance deleted");
    }
}
