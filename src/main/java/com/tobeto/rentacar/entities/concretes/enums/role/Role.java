package com.tobeto.rentacar.entities.concretes.enums.role;

import org.springframework.security.core.GrantedAuthority;

/**
 * Enum representing roles in the Rent a Car system.
 * Each role has a unique authority, and they are used for authorization purposes.
 * <p>
 * It implements the GrantedAuthority interface for Spring Security integration.
 *
 * @author [Harun Yılmaz]
 * @see org.springframework.security.core.GrantedAuthority
 * @see com.tobeto.rentacar.entities.concretes.User
 */

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
