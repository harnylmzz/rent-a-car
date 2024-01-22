package com.tobeto.rentacar.config.modelmapper;

import org.modelmapper.ModelMapper;

/**
 * Interface defining methods for managing ModelMapper instances in the Rent a Car system.
 * Specifies methods for configuring ModelMapper instances for response and request mappings.
 *
 * @author [Harun Yılmaz]
 * @see org.modelmapper.ModelMapper
 */

public interface ModelMapperService {

    ModelMapper forResponse();

    ModelMapper forRequest();
}
