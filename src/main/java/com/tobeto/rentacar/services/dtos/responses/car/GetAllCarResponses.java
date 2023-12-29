package com.tobeto.rentacar.services.dtos.responses.car;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarResponses {

    private int id;

    private double price;

    private String plate;

    private int kilometer;

    private int year;

    private int modelId;

    private int colorId;


    public GetAllCarResponses(int id, double price, String plate, int kilometer, int year) {
        this.id = id;
        this.price= price;
        this.plate= plate;
        this.kilometer=kilometer;
        this.year=year;
    }
}
