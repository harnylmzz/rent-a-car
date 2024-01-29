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
import com.tobeto.rentacar.services.constans.comprehensiveInsurance.ComprehensiveInsuranceMessages;
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

        return new DataResult<>(getAllComprehensiveInsurances, true, ComprehensiveInsuranceMessages.COMPREHENSIVE_INSURANCES_LISTED);
    }

    @Override
    public DataResult<GetByIdComprehensiveInsurance> getById(int id) {

        ComprehensiveInsurance comprehensiveInsurance = comprehensiveInsuranceRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(ComprehensiveInsuranceMessages.COMPREHENSIVE_INSURANCE_NOT_FOUND));

        GetByIdComprehensiveInsurance getByIdComprehensiveInsurance = this.modelMapperService.forResponse()
                .map(comprehensiveInsurance, GetByIdComprehensiveInsurance.class);

        return new DataResult<>(getByIdComprehensiveInsurance, true, ComprehensiveInsuranceMessages.COMPREHENSIVE_INSURANCES_LISTED);
    }

    @Override
    public Result add(CreateComprehensiveInsuranceRequests createComprehensiveInsuranceRequests) {

        ComprehensiveInsurance comprehensiveInsurance = this.modelMapperService.forRequest()
                .map(createComprehensiveInsuranceRequests, ComprehensiveInsurance.class);

        this.comprehensiveInsuranceRepository.save(comprehensiveInsurance);
        return new SuccessResult(ComprehensiveInsuranceMessages.COMPREHENSIVE_INSURANCE_ADDED);
    }

    @Override
    public Result update(UpdateComprehensiveInsuranceRequests updateComprehensiveInsuranceRequests) {

        ComprehensiveInsurance comprehensiveInsurance = this.modelMapperService.forRequest()
                .map(updateComprehensiveInsuranceRequests, ComprehensiveInsurance.class);

        comprehensiveInsurance.setId(updateComprehensiveInsuranceRequests.getId());
        comprehensiveInsurance.setDeductibleAmount(updateComprehensiveInsuranceRequests.getDeductibleAmount());

        this.comprehensiveInsuranceRepository.save(comprehensiveInsurance);
        return new SuccessResult(ComprehensiveInsuranceMessages.COMPREHENSIVE_INSURANCE_UPDATED);
    }

    @Override
    public Result delete(DeleteComprehensiveInsuranceRequests deleteComprehensiveInsuranceRequests) {

        ComprehensiveInsurance comprehensiveInsurance = this.modelMapperService.forRequest()
                .map(deleteComprehensiveInsuranceRequests, ComprehensiveInsurance.class);

        this.comprehensiveInsuranceRepository.delete(comprehensiveInsurance);
        return new SuccessResult(ComprehensiveInsuranceMessages.COMPREHENSIVE_INSURANCE_DELETED);
    }
}
