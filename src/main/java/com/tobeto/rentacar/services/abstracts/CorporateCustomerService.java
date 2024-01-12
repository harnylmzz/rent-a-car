package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.dtos.requests.corporateCustomer.CreateCorporateCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.corporateCustomer.DeleteCorporateCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.corporateCustomer.UpdateCorporateCustomerRequests;
import com.tobeto.rentacar.services.dtos.responses.corporateCustomer.GetAllCorporateCustomer;
import com.tobeto.rentacar.services.dtos.responses.corporateCustomer.GetByIdCorporateCustomer;

import java.util.List;

public interface CorporateCustomerService {

    DataResult<List<GetAllCorporateCustomer>> getAll();

    DataResult<GetByIdCorporateCustomer> getById(int id);

    Result add(CreateCorporateCustomerRequests createCorporateCustomerRequests);

    Result update(UpdateCorporateCustomerRequests updateCorporateCustomerRequests);

    Result delete(DeleteCorporateCustomerRequests deleteCorporateCustomerRequests);
}
