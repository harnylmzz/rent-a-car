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
public class GetAllCarResponses {

    private int id;

    private double price;

    private String plate;

    private String gearType;

    private int kilometer;

    private int year;

    private String modelName;

    private int colorId;

    private String colorName;

    private String fuelType;

    private int categoryId;

    private String categoryName;

    private int brandId;

    private String brandName;

    private String description;

    private Boolean isAvailable;

    private int numberOfSeats;

    private List<ImageModel> images;

}
