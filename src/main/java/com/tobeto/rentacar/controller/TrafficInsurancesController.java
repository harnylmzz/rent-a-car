package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.TrafficInsuranceService;
import com.tobeto.rentacar.services.dtos.requests.trafficInsurance.CreateTrafficInsuranceRequests;
import com.tobeto.rentacar.services.dtos.requests.trafficInsurance.DeleteTrafficInsuranceRequests;
import com.tobeto.rentacar.services.dtos.requests.trafficInsurance.UpdateTrafficInsuranceRequests;
import com.tobeto.rentacar.services.dtos.responses.trafficInsurance.GetAllTrafficInsuranceResponses;
import com.tobeto.rentacar.services.dtos.responses.trafficInsurance.GetByIdTrafficInsuranceResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/traffic-insurances")
public class TrafficInsurancesController {

    private final TrafficInsuranceService trafficInsuranceService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllTrafficInsuranceResponses>> getAll() {
        return this.trafficInsuranceService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdTrafficInsuranceResponses> getById(int id) {
        return this.trafficInsuranceService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateTrafficInsuranceRequests createTrafficInsuranceRequests) {
        return this.trafficInsuranceService.add(createTrafficInsuranceRequests);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateTrafficInsuranceRequests updateTrafficInsuranceRequests) {
        return this.trafficInsuranceService.update(updateTrafficInsuranceRequests);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteTrafficInsuranceRequests deleteTrafficInsuranceRequests) {
        return this.trafficInsuranceService.delete(deleteTrafficInsuranceRequests);
    }
}
