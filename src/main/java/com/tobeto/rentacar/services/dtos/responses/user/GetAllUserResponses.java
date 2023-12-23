package com.tobeto.rentacar.services.dtos.responses.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUserResponses {

    private int id;

    private String firstName;

    private String lastName;
}
