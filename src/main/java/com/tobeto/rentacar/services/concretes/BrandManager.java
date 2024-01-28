package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.Brand;

import com.tobeto.rentacar.repository.BrandRepository;
import com.tobeto.rentacar.services.abstracts.BrandService;
import com.tobeto.rentacar.services.dtos.requests.brand.CreateBrandRequests;
import com.tobeto.rentacar.services.dtos.requests.brand.DeleteBrandRequests;
import com.tobeto.rentacar.services.dtos.requests.brand.UpdateBrandRequests;
import com.tobeto.rentacar.services.dtos.responses.brand.GetAllBrandResponses;
import com.tobeto.rentacar.services.dtos.responses.brand.GetByIdBrandResponses;

import com.tobeto.rentacar.services.messages.brand.BrandMessages;
import com.tobeto.rentacar.services.rules.brand.BrandBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;
    private final BrandBusinessRules brandBusinessRules;

    @Override
    public DataResult<List<GetAllBrandResponses>> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandResponses> getAllBrandResponses = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandResponses.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllBrandResponses, true, BrandMessages.BRANDS_LISTED);
    }

    @Override
    public DataResult<GetByIdBrandResponses> getById(int id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(BrandMessages.BRAND_NOT_FOUND) {
                });
        GetByIdBrandResponses getByIdBrandResponses = this.modelMapperService.forResponse()
                .map(brand, GetByIdBrandResponses.class);

        return new DataResult<>(getByIdBrandResponses, true, BrandMessages.BRANDS_LISTED);
    }

    @Override
    public Result add(CreateBrandRequests createBrandRequests) {
        String name = createBrandRequests.getName().replace(" ", "");

        this.brandBusinessRules.checkIfName(createBrandRequests.getName());

        Brand brand = this.modelMapperService.forRequest()
                .map(createBrandRequests, Brand.class);
        this.brandRepository.save(brand);

        return new SuccessResult(BrandMessages.BRAND_ADDED);
    }

    @Override
    public Result update(UpdateBrandRequests updateBrandRequests) {
        Brand brand = this.modelMapperService.forRequest()
                .map(updateBrandRequests, Brand.class);
        brand.setId(updateBrandRequests.getId());
        brand.setName(updateBrandRequests.getName());

        this.brandRepository.save(brand);

        return new SuccessResult(BrandMessages.BRAND_UPDATED);
    }

    @Override
    public Result delete(DeleteBrandRequests deleteBrandRequests) {
        Brand brand = this.modelMapperService.forRequest()
                .map(deleteBrandRequests, Brand.class);
        this.brandRepository.delete(brand);

        return new SuccessResult(BrandMessages.BRAND_DELETED);
    }

    @Override
    public List<GetAllBrandResponses> findByName(String name) {
        List<Brand> brands = brandRepository.findByName(name);
        List<GetAllBrandResponses> findByNameResponses = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandResponses.class))
                .collect(Collectors.toList());

        return findByNameResponses;
    }

    @Override
    public List<GetAllBrandResponses> findByNameStartingWith(String name) {
        List<Brand> brands = brandRepository.findByNameStartingWith(name);
        List<GetAllBrandResponses> findByNameStartingWithResponses = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandResponses.class))
                .collect(Collectors.toList());

        return findByNameStartingWithResponses;
    }

    @Override
    public List<GetAllBrandResponses> findByNameEndingWith(String name) {
        List<Brand> brands = brandRepository.findByNameEndingWith(name);
        List<GetAllBrandResponses> findByNameEndingWithResponses = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandResponses.class))
                .collect(Collectors.toList());

        return findByNameEndingWithResponses;
    }

    @Override
    public List<GetAllBrandResponses> findByNameContaining(String name) {
        List<Brand> brands = brandRepository.findByNameContaining(name);
        List<GetAllBrandResponses> findByNameContainingResponses = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandResponses.class))
                .collect(Collectors.toList());

        return findByNameContainingResponses;
    }
}

