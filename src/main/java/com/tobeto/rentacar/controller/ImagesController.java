package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.abstracts.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping(value = "/save", consumes = "multipart/form-data")
    public DataResult<Object> save(@RequestParam("file") MultipartFile file, int carId) {
        return this.imageService.save(file, carId);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam String url) {
        return this.imageService.delete(url);
    }

}
