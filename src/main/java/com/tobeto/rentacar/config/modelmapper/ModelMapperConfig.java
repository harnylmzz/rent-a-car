package com.tobeto.rentacar.config.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for handling ModelMapper bean creation in the Rent a Car system.
 * It defines a ModelMapper bean to be used for mapping between different model classes.
 *
 * @author [Harun Yılmaz]
 */

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
