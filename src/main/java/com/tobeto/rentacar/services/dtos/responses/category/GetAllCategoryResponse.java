package com.tobeto.rentacar.services.dtos.responses.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCategoryResponse implements Serializable {
    private int id;
    private String name;
}
