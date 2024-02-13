package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.ColorService;
import com.tobeto.rentacar.services.dtos.requests.color.CreateColorRequests;
import com.tobeto.rentacar.services.dtos.requests.color.DeleteColorRequests;
import com.tobeto.rentacar.services.dtos.requests.color.UpdateColorRequests;
import com.tobeto.rentacar.services.dtos.responses.category.GetAllCategoryResponse;
import com.tobeto.rentacar.services.dtos.responses.color.GetAllColorResponses;
import com.tobeto.rentacar.services.dtos.responses.color.GetByIdColorResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing color-related endpoints in the Rent a Car system.
 * Provides endpoints for retrieving, adding, updating, and deleting colors.
 * Utilizes the ColorService for color-related operations.
 *
 * @author [Harun Yılmaz]
 */

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/colors")
public class ColorsController {
    private final ColorService colorService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllColorResponses>> getAll() {

        return this.colorService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdColorResponses> getById(int id) {
        return colorService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateColorRequests createColorRequests) {
        return this.colorService.add(createColorRequests);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateColorRequests updateColorRequests) {
        return this.colorService.update(updateColorRequests);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteColorRequests deleteColorRequests) {
        return this.colorService.delete(deleteColorRequests);
    }

    @GetMapping("/findByName")
    public List<GetAllColorResponses> findByName(String name){
        return this.colorService.findByName(name);
    }
    @GetMapping("/findByNameStartingWith")
    public List<GetAllColorResponses> findByNameStartingWith(String name) {
        return this.colorService.findByNameStartingWith(name);
    }

    @GetMapping("/findByNameEndingWith")
    public List<GetAllColorResponses> findByNameEndingWith(String name) {
        return this.colorService.findByNameEndingWith(name);
    }

    @GetMapping("/findByNameContaining")
    public List<GetAllColorResponses> findByNameContaining(String name) {
        return this.colorService.findByNameContaining(name);
    }

}
