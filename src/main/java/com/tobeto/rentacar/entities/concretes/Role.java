package com.tobeto.rentacar.entities.concretes;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER"),
    ROLE_MODERATOR("ROLE_MODERATOR"),
    ROLE_CORPORATE("ROLE_CORPORATE"),
    ROLE_INDIVIDUAL("ROLE_INDIVIDUAL"),
    ROLE_EMPLOYEE("ROLE_EMPLOYEE");

    private String value;

    Role(String value) {
        this.value = value;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
