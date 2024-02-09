package com.tobeto.rentacar.services.dtos.responses.car;

import com.tobeto.rentacar.core.cloudinary.ImageModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCarResponses implements Serializable {

    private int id;

    private double price;

    private String plate;

    private String gearType;

    private int kilometer;

    private int year;

    private String modelName;

    private String colorName;

    private String fuelType;

    private String categoryName;

    private int brand_id;

    private String amount_of_fuel;

    private int number_of_seats;

    private String description;

    private List<ImageModel> images;

}
