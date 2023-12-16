package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.entities.Brand;

import com.tobeto.rentacar.repository.BrandRepository;
import com.tobeto.rentacar.services.abstracts.BrandService;
import com.tobeto.rentacar.services.dtos.requests.brand.CreateBrandRequests;
import com.tobeto.rentacar.services.dtos.requests.brand.DeleteBrandRequests;
import com.tobeto.rentacar.services.dtos.requests.brand.UpdateBrandRequests;
import com.tobeto.rentacar.services.dtos.responses.brand.GetAllBrandResponses;
import com.tobeto.rentacar.services.dtos.responses.brand.GetByIdBrandResponses;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllBrandResponses> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandResponses> getAllBrandResponses = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandResponses.class))
                .collect(Collectors.toList());

        return getAllBrandResponses;
    }

    @Override
    public GetByIdBrandResponses getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponses getByIdBrandResponses = this.modelMapperService.forResponse()
                .map(brand, GetByIdBrandResponses.class);

        return getByIdBrandResponses;
    }

    @Override
    public void add(CreateBrandRequests createBrandRequests) {
        String name = createBrandRequests.getName().replace(" ", ""); // Boşlukları kaldır

        if (this.brandRepository.existsByName(name)) {
            throw new RuntimeException("Car with this plate already exists!");
        }
        Brand brand = this.modelMapperService.forRequest()
                .map(createBrandRequests, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequests updateBrandRequests) {
        Brand brand =this.modelMapperService.forRequest()
                .map(updateBrandRequests, Brand.class);
        brand.setId(updateBrandRequests.getId());
        brand.setName(updateBrandRequests.getName());
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(DeleteBrandRequests deleteBrandRequests) {
        Brand brand = this.modelMapperService.forRequest()
                .map(deleteBrandRequests , Brand.class);
        this.brandRepository.delete(brand);
    }
}
