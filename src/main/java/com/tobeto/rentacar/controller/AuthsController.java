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
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling authentication-related endpoints in the Rent a Car system.
 * Provides endpoints for user registration and login.
 * Uses the AuthService and JwtService for user registration and authentication, respectively.
 * Utilizes the AuthenticationManager for handling user authentication.
 *
 * @author [Harun Yılmaz]
 */

@Slf4j
@RestController
@RequestMapping("/api/v1/auths")
@RequiredArgsConstructor
@CrossOrigin
public class AuthsController {

    private final AuthService authService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public User register(@RequestBody CreateUserRequests createUserRequest) {
        return this.authService.register(createUserRequest);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(loginRequest.username());
        }
        log.info("invalid username " + loginRequest.username());
        throw new UsernameNotFoundException("invalid username {} " + loginRequest.username());
    }
}
