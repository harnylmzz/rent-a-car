package com.tobeto.rentacar.services.dtos.requests.user;

import com.tobeto.rentacar.entities.concretes.enums.Role;
import lombok.Builder;

import java.util.Set;

@Builder
public record CreateUserRequests (
        String firstName,
        String lastName,
        String email,
        String gsm,
        String username,
        String password,
        Set<Role> authorities
        ) {
}
