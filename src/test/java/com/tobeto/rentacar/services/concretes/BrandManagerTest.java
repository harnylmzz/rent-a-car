package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.entities.concretes.Brand;
import com.tobeto.rentacar.repository.BrandRepository;
import com.tobeto.rentacar.services.dtos.responses.brand.GetAllBrandResponses;
import com.tobeto.rentacar.services.rules.BrandBusinessRules;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BrandManagerTest {

    private BrandManager brandManager;
    private BrandRepository brandRepository;
    private BrandBusinessRules brandBusinessRules;
    private ModelMapperService modelMapperService;

    @BeforeEach
    public void setUp() {
        brandRepository = Mockito.mock(BrandRepository.class);
        brandBusinessRules = Mockito.mock(BrandBusinessRules.class);
        modelMapperService = Mockito.mock(ModelMapperService.class);

        brandManager = new BrandManager(brandRepository, modelMapperService, brandBusinessRules);
    }

    @Test
    @DisplayName("getAll should return list of brands")
    public void getAll_shouldReturnListOfBrands() {

    }

    @AfterEach
    public void tearDown() {
        // Add any necessary cleanup actions here
    }
}
