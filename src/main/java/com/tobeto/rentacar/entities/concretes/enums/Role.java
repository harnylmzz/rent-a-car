package com.tobeto.rentacar.entities.concretes.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_EMPLOYEE("ROLE_EMPLOYEE"),

    ROLE_CUSTOMER("ROLE_CUSTOMER");

    private String value;

    Role(String value) {
        this.value = value;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
