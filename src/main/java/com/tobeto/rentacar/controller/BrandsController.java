package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.BrandService;
import com.tobeto.rentacar.services.dtos.requests.brand.CreateBrandRequests;
import com.tobeto.rentacar.services.dtos.requests.brand.DeleteBrandRequests;
import com.tobeto.rentacar.services.dtos.requests.brand.UpdateBrandRequests;
import com.tobeto.rentacar.services.dtos.responses.brand.GetAllBrandResponses;
import com.tobeto.rentacar.services.dtos.responses.brand.GetByIdBrandResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling brand-related endpoints in the Rent a Car system.
 * Provides endpoints for retrieving, adding, updating, and deleting brands.
 * Utilizes the BrandService for brand-related operations.
 * Supports validation for request bodies.
 *
 * @author [Harun Yılmaz]
 */

@RestController
@RequestMapping("/api/v1/brands")
@RequiredArgsConstructor
@CrossOrigin
public class BrandsController {
    private final BrandService brandService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllBrandResponses>> getAll() {
        return this.brandService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdBrandResponses> getById(int id) {
        return brandService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateBrandRequests createBrandRequests) {
        return this.brandService.add(createBrandRequests);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateBrandRequests updateBrandRequest) {
        return this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteBrandRequests deleteBrandRequests) {
        return this.brandService.delete(deleteBrandRequests);
    }

    @GetMapping("/findByName")
    public List<GetAllBrandResponses> findByName(String name) {
        return this.brandService.findByName(name);
    }

    @GetMapping("/findByNameStartingWith")
    public List<GetAllBrandResponses> findByNameStartingWith(String name) {
        return this.brandService.findByNameStartingWith(name);
    }

    @GetMapping("/findByNameEndingWith")
    public List<GetAllBrandResponses> findByNameEndingWith(String name) {
        return this.brandService.findByNameEndingWith(name);
    }

    @GetMapping("/findByNameContaining")
    public List<GetAllBrandResponses> findByNameContaining(String name) {
        return this.brandService.findByNameContaining(name);
    }
}
