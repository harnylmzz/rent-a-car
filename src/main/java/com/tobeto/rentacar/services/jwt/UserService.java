package com.tobeto.rentacar.services.jwt;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.User;
import com.tobeto.rentacar.repository.UserRepository;
import com.tobeto.rentacar.services.dtos.requests.user.CreateUserRequests;
import com.tobeto.rentacar.services.dtos.requests.user.DeleteUserRequests;
import com.tobeto.rentacar.services.dtos.requests.user.UpdateUserRequests;
import com.tobeto.rentacar.services.dtos.responses.user.GetAllUserResponses;
import com.tobeto.rentacar.services.dtos.responses.user.GetByIdUserResponses;
import com.tobeto.rentacar.services.rules.UserBusinessRules;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserBusinessRules userBusinessRules;
    private final ModelMapperService modelMapperService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.orElseThrow(EntityNotFoundException::new);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(CreateUserRequests createUserRequest) {

        this.userBusinessRules.checkIfUserExists(createUserRequest.email(), createUserRequest.gsm());


        User user = User.builder()
                .firstName(createUserRequest.firstName())
                .lastName(createUserRequest.lastName())
                .email(createUserRequest.email())
                .gsm(createUserRequest.gsm())
                .username(createUserRequest.username())
                .password(bCryptPasswordEncoder.encode(createUserRequest.password()))
                .authorities(createUserRequest.authorities())
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .isEnabled(true)
                .accountNonLocked(true)
                .build();

        return userRepository.save(user);
    }

    public Result updateUser(UpdateUserRequests updateUserRequests) {

        User user = this.modelMapperService.forRequest()
                .map(updateUserRequests, User.class);

        userRepository.save(user);

        return new SuccessResult("User updated.");
    }

    public Result deleteUser(DeleteUserRequests deleteUserRequests) {

        User user = this.modelMapperService.forRequest()
                .map(deleteUserRequests, User.class);

        userRepository.delete(user);

        return new SuccessResult("User deleted.");
    }

    public DataResult<GetByIdUserResponses> getById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Data not found.") {
        });

        GetByIdUserResponses getByIdUserResponses = this.modelMapperService.forResponse()
                .map(user, GetByIdUserResponses.class);

        return new DataResult<>(getByIdUserResponses, true, "User listed.");
    }

    public DataResult<List<GetAllUserResponses>> getAll() {
        List<User> users = userRepository.findAll();
        List<GetAllUserResponses> getAllUserResponses = users.stream()
                .map(user -> this.modelMapperService.forResponse()
                        .map(user, GetAllUserResponses.class))
                .toList();

        return new DataResult<>(getAllUserResponses, true, "Users listed.");
    }
}
