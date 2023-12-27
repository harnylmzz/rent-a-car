package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.ImageService;
import com.tobeto.rentacar.services.dtos.requests.image.CreateImageRequests;
import com.tobeto.rentacar.services.dtos.requests.image.DeleteImageRequests;
import com.tobeto.rentacar.services.dtos.requests.image.UpdateImageRequests;
import com.tobeto.rentacar.services.dtos.responses.image.GetAllImageResponses;
import com.tobeto.rentacar.services.dtos.responses.image.GetByIdImageResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
@AllArgsConstructor
public class ImagesController {

    private ImageService imageService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllImageResponses>> getAll() {
        return this.imageService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdImageResponses> getById(int id) {
        return imageService.getById(id);
    }

    @PostMapping("/add")
    public Result add(CreateImageRequests createImageRequests) {
        return this.imageService.add(createImageRequests);
    }

    @PutMapping("/update")
    public Result update(UpdateImageRequests updateImageRequests) {
        return this.imageService.update(updateImageRequests);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteImageRequests deleteImageRequests) {
        return this.imageService.delete(deleteImageRequests);
    }
}
