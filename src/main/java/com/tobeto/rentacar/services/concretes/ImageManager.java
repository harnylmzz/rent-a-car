package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.Image;
import com.tobeto.rentacar.repository.ImageRepository;
import com.tobeto.rentacar.services.abstracts.ImageService;
import com.tobeto.rentacar.services.dtos.requests.brand.UpdateBrandRequests;
import com.tobeto.rentacar.services.dtos.requests.image.CreateImageRequests;
import com.tobeto.rentacar.services.dtos.requests.image.DeleteImageRequests;
import com.tobeto.rentacar.services.dtos.requests.image.UpdateImageRequests;
import com.tobeto.rentacar.services.dtos.responses.image.GetAllImageResponses;
import com.tobeto.rentacar.services.dtos.responses.image.GetByIdImageResponses;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImageManager implements ImageService {

    private final ImageRepository imageRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllImageResponses>> getAll() {

        List<Image> images = imageRepository.findAll();
        List<GetAllImageResponses> getAllImageResponses = images.stream()
                .map(image -> this.modelMapperService.forResponse()
                        .map(image, GetAllImageResponses.class)).collect(Collectors.toList());
        return new DataResult<>(getAllImageResponses, true, "Images listed");
    }

    @Override
    public DataResult<GetByIdImageResponses> getById(int id) {

        Image image = imageRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Data not found."));
        GetByIdImageResponses getByIdImageResponses = this.modelMapperService.forResponse()
                .map(image, GetByIdImageResponses.class);

        return new DataResult<>(getByIdImageResponses, true, "Image listed");
    }

    @Override
    public Result add(CreateImageRequests createImageRequests) {

        Image image = this.modelMapperService.forRequest()
                .map(createImageRequests, Image.class);

        this.imageRepository.save(image);

        return new SuccessResult("Image added");
    }

    @Override
    public Result update(UpdateImageRequests updateImageRequests) {

        Image image = this.modelMapperService.forRequest()
                .map(updateImageRequests, Image.class);

        image.setUrl(updateImageRequests.getUrl());

        this.imageRepository.save(image);
        return new SuccessResult("Image updated");
    }

    @Override
    public Result delete(DeleteImageRequests deleteImageRequests) {

        Image image = this.modelMapperService.forRequest()
                .map(deleteImageRequests, Image.class);

        this.imageRepository.delete(image);
        return new SuccessResult("Image deleted");
    }

    @Override
    public List<GetAllImageResponses> findByUrl(String url) {
        List<Image> images = imageRepository.findByUrl(url);
        List<GetAllImageResponses> findByUrlResponses = images.stream()
                .map(image -> this.modelMapperService.forResponse()
                        .map(image, GetAllImageResponses.class))
                .collect(Collectors.toList());

        return findByUrlResponses;
    }
}
