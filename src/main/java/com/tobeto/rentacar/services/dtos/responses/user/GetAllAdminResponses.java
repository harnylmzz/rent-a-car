package com.tobeto.rentacar.services.dtos.responses.user;

import com.tobeto.rentacar.entities.concretes.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAdminResponses {

    private int id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private Set<Role> authorities;

}
