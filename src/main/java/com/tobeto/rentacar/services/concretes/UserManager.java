package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.User;
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
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private UserRepository userRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllUserResponses>> getAll() {
        List<User> users = userRepository.findAll();
        List<GetAllUserResponses> getAllUserResponses = users.stream()
                .map(user -> this.modelMapperService.forResponse()
                        .map(user, GetAllUserResponses.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllUserResponses, true, "Users listed");
    }

    @Override
    public DataResult<GetByIdUserResponses> getById(int id) {
        User user = userRepository.findById(id).orElseThrow();
        GetByIdUserResponses getByIdUserResponses = this.modelMapperService.forResponse()
                .map(user, GetByIdUserResponses.class);
        return new DataResult<>(getByIdUserResponses, true, "User listed");
    }

    @Override
    public Result add(CreateUserRequests createUserRequests) {
        User user = this.modelMapperService.forRequest()
                .map(createUserRequests, User.class);
        this.userRepository.save(user);

        return new SuccessResult("User added");
    }

    @Override
    public Result update(UpdateUserRequests updateUserRequests) {
        User user = this.modelMapperService.forRequest()
                .map(updateUserRequests, User.class);
        user.setId(updateUserRequests.getId());
        user.setFirstName(updateUserRequests.getFirstName());
        user.setLastName(updateUserRequests.getLastName());
        user.setEmail(updateUserRequests.getEmail());
        user.setGsm(updateUserRequests.getGsm());
        this.userRepository.save(user);

        return new SuccessResult("User updated");
    }

    @Override
    public Result delete(DeleteUserRequests deleteUserRequests) {
        User user = this.modelMapperService.forRequest()
                .map(deleteUserRequests, User.class);
        this.userRepository.delete(user);

        return new SuccessResult("User deleted");
    }
}
