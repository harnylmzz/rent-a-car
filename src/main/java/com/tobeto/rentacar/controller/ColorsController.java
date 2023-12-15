package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.services.abstracts.ColorService;
import com.tobeto.rentacar.services.dtos.requests.color.CreateColorRequests;
import com.tobeto.rentacar.services.dtos.requests.color.DeleteColorRequests;
import com.tobeto.rentacar.services.dtos.requests.color.UpdateColorRequests;
import com.tobeto.rentacar.services.dtos.responses.color.GetAllColorResponses;
import com.tobeto.rentacar.services.dtos.responses.color.GetByIdColorResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/colors")
public class ColorsController {
    private ColorService colorService;


    @GetMapping("/getAll")
    public List<GetAllColorResponses> getAll() {

        return this.colorService.getAll();
    }

    @GetMapping("/getById")
    public GetByIdColorResponses getById(
            @PathVariable int id) {
        return colorService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateColorRequests createColorRequests) {
        this.colorService.add(createColorRequests);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateColorRequests updateColorRequests) {
        this.colorService.update(updateColorRequests);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteColorRequests deleteColorRequests) {
        this.colorService.delete(deleteColorRequests);
    }

}
