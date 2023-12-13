package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.repository.UserRepository;
import com.tobeto.rentacar.services.abstracts.UserService;
import com.tobeto.rentacar.services.dtos.requests.user.CreateUserRequests;
import com.tobeto.rentacar.services.dtos.requests.user.DeleteUserRequests;
import com.tobeto.rentacar.services.dtos.requests.user.UpdateUserRequests;
import com.tobeto.rentacar.services.dtos.responses.user.GetAllUserResponses;
import com.tobeto.rentacar.services.dtos.responses.user.GetByIdUserResponses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private UserRepository userRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllUserResponses> getAll() {
        return null;
    }

    @Override
    public GetByIdUserResponses getById(int id) {
        return null;
    }

    @Override
    public void add(CreateUserRequests createUserRequests) {

    }

    @Override
    public void update(UpdateUserRequests updateUserRequests) {

    }

    @Override
    public void delete(DeleteUserRequests deleteUserRequests) {

    }
}
