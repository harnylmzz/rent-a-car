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
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

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
        return  this.brandService.delete(deleteBrandRequests);
    }

    @GetMapping("/findbyname")
    public List<GetAllBrandResponses> findByName(@RequestParam String name) {
        return this.brandService.findByName(name);
    }

    @GetMapping("/findbynamestartingwith")
    public List<GetAllBrandResponses> findByNameStartingWith(@RequestParam String name) {
        return this.brandService.findByNameStartingWith(name);
    }

    @GetMapping("/findbynameendingwith")
    public List<GetAllBrandResponses> findByNameEndingWith(@RequestParam String name) {
        return this.brandService.findByNameEndingWith(name);
    }

    @GetMapping("/findbynamecontaining")
    public List<GetAllBrandResponses> findByNameContaining(@RequestParam String name) {
        return this.brandService.findByNameContaining(name);
    }


}
