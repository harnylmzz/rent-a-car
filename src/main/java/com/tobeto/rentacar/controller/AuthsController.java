package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.entities.concretes.User;
import com.tobeto.rentacar.services.dtos.requests.user.CreateUserRequests;
import com.tobeto.rentacar.services.dtos.requests.user.LoginRequest;
import com.tobeto.rentacar.services.jwt.AuthService;
import com.tobeto.rentacar.services.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/auths")
@RequiredArgsConstructor
public class AuthsController {

    private final AuthService authService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public User register(@RequestBody CreateUserRequests createUserRequest) {
        return this.authService.register(createUserRequest);
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
