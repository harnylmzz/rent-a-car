package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.services.abstracts.BrandService;
import com.tobeto.rentacar.services.dtos.requests.brand.CreateBrandRequests;
import com.tobeto.rentacar.services.dtos.requests.brand.DeleteBrandRequests;
import com.tobeto.rentacar.services.dtos.requests.brand.UpdateBrandRequests;
import com.tobeto.rentacar.services.dtos.requests.car.CreateCarRequests;
import com.tobeto.rentacar.services.dtos.requests.car.DeleteCarRequests;
import com.tobeto.rentacar.services.dtos.requests.car.UpdateCarRequests;
import com.tobeto.rentacar.services.dtos.responses.brand.GetAllBrandResponses;
import com.tobeto.rentacar.services.dtos.responses.brand.GetByIdBrandResponses;
import com.tobeto.rentacar.services.dtos.responses.car.GetAllCarResponses;
import com.tobeto.rentacar.services.dtos.responses.car.GetByIdCarResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @GetMapping("/getAll")
    public List<GetAllBrandResponses> getAll() {
        return this.brandService.getAll();
    }

    @GetMapping("/getById")
    public GetByIdBrandResponses getById(int id) {
        return brandService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody @Valid CreateBrandRequests createBrandRequests) {
        this.brandService.add(createBrandRequests);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateBrandRequests updateBrandRequest) {
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteBrandRequests deleteBrandRequests) {
        this.brandService.delete(deleteBrandRequests);
    }



}
