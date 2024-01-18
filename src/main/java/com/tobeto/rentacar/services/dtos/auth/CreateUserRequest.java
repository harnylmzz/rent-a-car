package com.tobeto.rentacar.services.dtos.auth;

import com.tobeto.rentacar.entities.concretes.Role;
import lombok.Builder;

import java.util.Set;

@Builder
public record CreateUserRequest(
        String firstName,
        String lastName,
        String email,
        String gsm,
        String username,
        String password,
        Set<Role> authorities
        ) {
}
