package com.tobeto.rentacar.services.dtos.auth;

public record AuthRequest(

        String username,
        String password
) {
}
