package com.tobeto.rentacar.config.cloudinary;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {

        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dgdoapdu0");
        config.put("api_key", "287887413197473");
        config.put("api_secret", "5vPDGr3CUcZapi4OqFSJxYdC6fw");
        return new Cloudinary(config);
    }
}
