package com.tobeto.rentacar.core.cloudinary;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class ImageModel {

    private int id;

    private String url;

    private String publicId;

    private int width;

    private int height;

    private String format;

    private int bytes;

    private int carId;
}
