package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.ModelService;
import com.tobeto.rentacar.services.dtos.requests.model.CreateModelRequests;
import com.tobeto.rentacar.services.dtos.requests.model.DeleteModelRequests;
import com.tobeto.rentacar.services.dtos.requests.model.UpdateModelRequests;
import com.tobeto.rentacar.services.dtos.responses.model.GetAllModelResponses;
import com.tobeto.rentacar.services.dtos.responses.model.GetByIdModelResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing model-related endpoints in the Rent a Car system.
 * Provides endpoints for retrieving, adding, updating, and deleting models.
 * Utilizes the ModelService for model-related operations.
 *
 * @author [Harun Yılmaz]
 */

@RestController
@RequestMapping("/api/v1/models")
@RequiredArgsConstructor
public class ModelsController {
    private final ModelService modelService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllModelResponses>> getAll() {
        return this.modelService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdModelResponses> getById(int id) {
        return modelService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateModelRequests createModelRequests) {
        return this.modelService.add(createModelRequests);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateModelRequests updateCarRequest) {
        return this.modelService.update(updateCarRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody DeleteModelRequests deleteCarRequests) {
        return this.modelService.delete(deleteCarRequests);
    }

    @GetMapping("/findbyname")
    public List<GetAllModelResponses> findByName(String name) {
        return this.modelService.findByName(name);
    }
}
