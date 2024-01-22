package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.dtos.requests.user.DeleteUserRequests;
import com.tobeto.rentacar.services.dtos.requests.user.UpdateUserRequests;
import com.tobeto.rentacar.services.dtos.responses.brand.GetByIdBrandResponses;
import com.tobeto.rentacar.services.dtos.responses.user.GetAllUserResponses;
import com.tobeto.rentacar.services.dtos.responses.user.GetByIdUserResponses;

import java.util.List;

public interface UserService {
    DataResult<List<GetAllUserResponses>> getAll();

    DataResult<GetByIdUserResponses> getById(int id);

    Result update(UpdateUserRequests updateUserRequests);

    Result delete(DeleteUserRequests deleteUserRequests);
}
