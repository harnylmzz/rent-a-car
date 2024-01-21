package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.ComprehensiveInsuranceService;
import com.tobeto.rentacar.services.dtos.requests.comprehensiveInsurance.CreateComprehensiveInsuranceRequests;
import com.tobeto.rentacar.services.dtos.requests.comprehensiveInsurance.DeleteComprehensiveInsuranceRequests;
import com.tobeto.rentacar.services.dtos.requests.comprehensiveInsurance.UpdateComprehensiveInsuranceRequests;
import com.tobeto.rentacar.services.dtos.responses.comprehensiveInsurance.GetAllComprehensiveInsurance;
import com.tobeto.rentacar.services.dtos.responses.comprehensiveInsurance.GetByIdComprehensiveInsurance;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/comprehensiveInsurances")
@RestController
public class ComprehensiveInsurancesController {

    private final ComprehensiveInsuranceService comprehensiveInsuranceService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllComprehensiveInsurance>> getAll() {
        return this.comprehensiveInsuranceService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdComprehensiveInsurance> getById(int id) {
        return this.comprehensiveInsuranceService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateComprehensiveInsuranceRequests createComprehensiveInsuranceRequests) {
        return this.comprehensiveInsuranceService.add(createComprehensiveInsuranceRequests);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateComprehensiveInsuranceRequests updateComprehensiveInsuranceRequests) {
        return this.comprehensiveInsuranceService.update(updateComprehensiveInsuranceRequests);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteComprehensiveInsuranceRequests deleteComprehensiveInsuranceRequests) {
        return this.comprehensiveInsuranceService.delete(deleteComprehensiveInsuranceRequests);
    }
}
