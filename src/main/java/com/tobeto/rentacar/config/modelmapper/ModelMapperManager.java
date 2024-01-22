package com.tobeto.rentacar.config.modelmapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

/**
 * Service class managing ModelMapper instances for handling mappings in the Rent a Car system.
 * Implements the ModelMapperService interface.
 *
 * @author [Harun Yılmaz]
 * @see com.tobeto.rentacar.config.modelmapper.ModelMapperService
 */

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {

    private ModelMapper modelMapper;

    @Override
    public ModelMapper forResponse() {

        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {

        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;
    }
}
