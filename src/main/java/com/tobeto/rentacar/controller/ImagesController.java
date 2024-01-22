package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.ImageService;
import com.tobeto.rentacar.services.dtos.requests.image.CreateImageRequests;
import com.tobeto.rentacar.services.dtos.requests.image.DeleteImageRequests;
import com.tobeto.rentacar.services.dtos.requests.image.UpdateImageRequests;
import com.tobeto.rentacar.services.dtos.responses.image.GetAllImageResponses;
import com.tobeto.rentacar.services.dtos.responses.image.GetByIdImageResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing image-related endpoints in the Rent a Car system.
 * Provides endpoints for retrieving, adding, updating, deleting, and finding images by URL.
 * Utilizes the ImageService for image-related operations.
 *
 * @author [Harun Yılmaz]
 */

@RestController
@RequestMapping("/api/v1/images")
@RequiredArgsConstructor
@CrossOrigin
public class ImagesController {

    private final ImageService imageService;

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

    @GetMapping("/findbyurl")
    public List<GetAllImageResponses> findByUrl(String url) {
        return this.imageService.findByUrl(url);
    }

}
