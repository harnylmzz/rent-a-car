package com.tobeto.rentacar.core.cloudinary;

public class CloudinaryImageHelper {

    private CloudinaryImageHelper() {

    }
    public static String getImagePublicIdFromUrl(String url) {
        return url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
    }
}
