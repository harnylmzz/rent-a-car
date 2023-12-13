package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.requests.user.CreateUserRequests;
import com.tobeto.rentacar.services.dtos.requests.user.DeleteUserRequests;
import com.tobeto.rentacar.services.dtos.requests.user.UpdateUserRequests;
import com.tobeto.rentacar.services.dtos.responses.user.GetAllUserResponses;
import com.tobeto.rentacar.services.dtos.responses.user.GetByIdUserResponses;

import java.util.List;

public interface UserService {
    List<GetAllUserResponses> getAll();
    GetByIdUserResponses getById(int id);
    void add(CreateUserRequests createUserRequests);
    void update(UpdateUserRequests updateUserRequests);
    void delete(DeleteUserRequests deleteUserRequests);
}
