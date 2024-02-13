package com.tobeto.rentacar.services.dtos.requests.user;

import com.tobeto.rentacar.entities.concretes.enums.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequests {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String gsm;

    private String username;

    private String password;

    private Set<Role> authorities;
}
