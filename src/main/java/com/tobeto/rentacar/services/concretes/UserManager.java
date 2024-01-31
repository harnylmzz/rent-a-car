package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.User;
import com.tobeto.rentacar.repository.UserRepository;
import com.tobeto.rentacar.services.abstracts.UserService;
import com.tobeto.rentacar.services.constans.user.UserMessages;
import com.tobeto.rentacar.services.dtos.requests.user.CreateUserRequests;
import com.tobeto.rentacar.services.dtos.requests.user.DeleteUserRequests;
import com.tobeto.rentacar.services.dtos.requests.user.UpdateUserRequests;
import com.tobeto.rentacar.services.dtos.responses.user.GetAllUserResponses;
import com.tobeto.rentacar.services.dtos.responses.user.GetByIdUserResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;


    public DataResult<List<GetAllUserResponses>> getAll() {
        List<User> users = userRepository.findAll();
        List<GetAllUserResponses> getAllUserResponses = users.stream()
                .map(user -> this.modelMapperService.forResponse()
                        .map(user, GetAllUserResponses.class))
                .toList();

        return new DataResult<>(getAllUserResponses, true, UserMessages.USERS_LISTED);
    }

    public DataResult<GetByIdUserResponses> getById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new DataNotFoundException(UserMessages.DATA_NOT_FOUND));

        GetByIdUserResponses getByIdUserResponses = this.modelMapperService.forResponse()
                .map(user, GetByIdUserResponses.class);

        return new DataResult<>(getByIdUserResponses, true, UserMessages.USERS_LISTED);
    }

    @Override
    public Result add(CreateUserRequests createUserRequests) {

        userRepository.save(this.modelMapperService.forRequest()
                .map(createUserRequests, User.class));

        return new SuccessResult(UserMessages.USERS_ADDED);
    }

    public Result update(UpdateUserRequests updateUserRequests) {

        User user = this.modelMapperService.forRequest()
                .map(updateUserRequests, User.class);

        userRepository.save(user);

        return new SuccessResult(UserMessages.USERS_UPDATED);
    }

    public Result delete(DeleteUserRequests deleteUserRequests) {

        User user = this.modelMapperService.forRequest()
                .map(deleteUserRequests, User.class);

        userRepository.delete(user);

        return new SuccessResult(UserMessages.USERS_DELETED);
    }
}
