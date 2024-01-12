package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.dtos.requests.comprehensiveInsurance.CreateComprehensiveInsuranceRequests;
import com.tobeto.rentacar.services.dtos.requests.comprehensiveInsurance.DeleteComprehensiveInsuranceRequests;
import com.tobeto.rentacar.services.dtos.requests.comprehensiveInsurance.UpdateComprehensiveInsuranceRequests;
import com.tobeto.rentacar.services.dtos.responses.comprehensiveInsurance.GetAllComprehensiveInsurance;
import com.tobeto.rentacar.services.dtos.responses.comprehensiveInsurance.GetByIdComprehensiveInsurance;

import java.util.List;

public interface ComprehensiveInsuranceService {

    DataResult<List<GetAllComprehensiveInsurance>> getAll();

    DataResult<GetByIdComprehensiveInsurance> getById(int id);

    Result add(CreateComprehensiveInsuranceRequests createComprehensiveInsuranceRequests);

    Result update(UpdateComprehensiveInsuranceRequests updateComprehensiveInsuranceRequests);

    Result delete(DeleteComprehensiveInsuranceRequests deleteComprehensiveInsuranceRequests);
}
