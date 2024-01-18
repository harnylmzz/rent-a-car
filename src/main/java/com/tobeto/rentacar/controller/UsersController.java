package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.entities.concretes.User;
import com.tobeto.rentacar.services.dtos.auth.AuthRequest;
import com.tobeto.rentacar.services.dtos.auth.CreateUserRequest;
import com.tobeto.rentacar.services.jwt.JwtService;
import com.tobeto.rentacar.services.jwt.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
@AllArgsConstructor
public class UsersController {

    private UserService userService;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    @PostMapping("/addUser")
    public User addUser(@RequestBody CreateUserRequest createUserRequest) {
        return userService.createUser(createUserRequest);
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.username());
        }
        log.info("invalid username " + authRequest.username());
        throw new UsernameNotFoundException("invalid username {} " + authRequest.username());
    }

    @GetMapping("/user")
    public String getUserString() {
        return "This is USER!";
    }

    @GetMapping("/admin")
    public String getAdminString() {
        return "This is ADMIN!";
    }
}
