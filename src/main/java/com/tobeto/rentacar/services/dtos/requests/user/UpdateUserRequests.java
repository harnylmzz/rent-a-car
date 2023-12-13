package com.tobeto.rentacar.services.dtos.requests.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequests {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String gsm;
}
