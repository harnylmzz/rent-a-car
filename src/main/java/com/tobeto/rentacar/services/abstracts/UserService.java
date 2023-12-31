package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.entities.concretes.User;
import com.tobeto.rentacar.services.dtos.requests.user.CreateUserRequests;
import com.tobeto.rentacar.services.dtos.requests.user.DeleteUserRequests;
import com.tobeto.rentacar.services.dtos.requests.user.UpdateUserRequests;
import com.tobeto.rentacar.services.dtos.responses.user.GetAllUserResponses;
import com.tobeto.rentacar.services.dtos.responses.user.GetByIdUserResponses;

import java.util.List;

public interface UserService {
    DataResult<List<GetAllUserResponses>> getAll();

    DataResult<GetByIdUserResponses> getById(int id);

    Result add(CreateUserRequests createUserRequests);

    Result update(UpdateUserRequests updateUserRequests);

    Result delete(DeleteUserRequests deleteUserRequests);

    List<GetAllUserResponses> findByFirstName(String firstName);

    List<GetAllUserResponses> findByLastName( String lastName);

    List<GetAllUserResponses> findByEmail(String email);

    List<GetAllUserResponses> findByGsm(String gsm);
}
