package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.entities.concretes.User;
import com.tobeto.rentacar.services.dtos.requests.user.CreateUserRequests;
import com.tobeto.rentacar.services.dtos.requests.user.DeleteUserRequests;
import com.tobeto.rentacar.services.dtos.requests.user.LoginRequest;
import com.tobeto.rentacar.services.dtos.requests.user.UpdateUserRequests;
import com.tobeto.rentacar.services.dtos.responses.user.GetAllUserResponses;
import com.tobeto.rentacar.services.dtos.responses.user.GetByIdUserResponses;
import com.tobeto.rentacar.services.jwt.JwtService;
import com.tobeto.rentacar.services.jwt.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
@AllArgsConstructor
public class UsersController {

    private UserService userService;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    @GetMapping("/getUserById")
    public DataResult<GetByIdUserResponses> getUserById(int id) {
        return this.userService.getById(id);
    }

    @GetMapping("/getAllUser")
    public DataResult<List<GetAllUserResponses>> getAllUser() {
        return this.userService.getAll();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody CreateUserRequests createUserRequest) {
        return this.userService.createUser(createUserRequest);
    }

    @PutMapping("/updateUser")
    public Result updateUser(@RequestBody UpdateUserRequests updateUserRequests) {
        return this.userService.updateUser(updateUserRequests);
    }

    @DeleteMapping("/deleteUser")
    public Result deleteUser(@RequestBody DeleteUserRequests deleteUserRequests) {
      return   this.userService.deleteUser(deleteUserRequests);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.username());
        }
        log.info("invalid username " + authRequest.username());
        throw new UsernameNotFoundException("invalid username {} " + authRequest.username());
    }

}
