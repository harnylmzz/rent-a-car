package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.services.abstracts.ModelService;
import com.tobeto.rentacar.services.dtos.requests.model.CreateModelRequests;
import com.tobeto.rentacar.services.dtos.requests.model.DeleteModelRequests;
import com.tobeto.rentacar.services.dtos.requests.model.UpdateModelRequests;
import com.tobeto.rentacar.services.dtos.responses.model.GetAllModelResponses;
import com.tobeto.rentacar.services.dtos.responses.model.GetByIdModelResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;
    @GetMapping("/getAll")
    public List<GetAllModelResponses> getAll() {
        return this.modelService.getAll();
    }
    @GetMapping("/getById")
    public GetByIdModelResponses getById(@PathVariable int id) {
        return modelService.getById(id);
    }
    @PostMapping("/add")
    public void add(@RequestBody CreateModelRequests createModelRequests) {
        this.modelService.add(createModelRequests);
    }
    @PutMapping("/update")
    public void update(@RequestBody UpdateModelRequests updateCarRequest) {
        this.modelService.update(updateCarRequest);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteModelRequests deleteCarRequests) {
        this.modelService.delete(deleteCarRequests);
    }
}
