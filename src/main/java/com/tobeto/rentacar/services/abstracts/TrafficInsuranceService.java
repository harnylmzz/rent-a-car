package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.dtos.requests.trafficInsurance.CreateTrafficInsuranceRequests;
import com.tobeto.rentacar.services.dtos.requests.trafficInsurance.DeleteTrafficInsuranceRequests;
import com.tobeto.rentacar.services.dtos.requests.trafficInsurance.UpdateTrafficInsuranceRequests;
import com.tobeto.rentacar.services.dtos.responses.trafficInsurance.GetAllTrafficInsuranceResponses;
import com.tobeto.rentacar.services.dtos.responses.trafficInsurance.GetByIdTrafficInsuranceResponses;

import java.util.List;

public interface TrafficInsuranceService {

    DataResult<List<GetAllTrafficInsuranceResponses>> getAll();

    DataResult<GetByIdTrafficInsuranceResponses> getById(int id);

    Result add(CreateTrafficInsuranceRequests createTrafficInsuranceRequests);

    Result update(UpdateTrafficInsuranceRequests updateTrafficInsuranceRequests);

    Result delete(DeleteTrafficInsuranceRequests deleteTrafficInsuranceRequests);
}
