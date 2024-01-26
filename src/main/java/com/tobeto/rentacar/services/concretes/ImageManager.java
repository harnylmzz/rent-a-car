package com.tobeto.rentacar.services.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.cloudinary.CloudinaryImageHelper;
import com.tobeto.rentacar.core.cloudinary.ImageModel;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.*;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImageManager implements ImageService {

    private final ImageRepository imageRepository;
    private final ModelMapperService modelMapperService;
    private final Cloudinary cloudinary;

    @Override
    public DataResult<Object> save(MultipartFile file, int carId) {
        Map<?, ?> result;

        try {
            result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());
        }

        ImageModel imageModel = ImageModel.builder()
                .publicId(String.valueOf(result.get("public_id")))
                .url(String.valueOf(result.get("url")))
                .width((Integer) result.get("width"))
                .height((Integer) result.get("height"))
                .format(String.valueOf(result.get("format")))
                .bytes((Integer) result.get("bytes"))
                .carId(carId)
                .build();

        Image image = modelMapperService.forRequest().map(imageModel, Image.class);
        imageRepository.save(image);

        return new SuccessDataResult<>(image);
    }

    @Override
    public Result delete(String url) {

        try {
            cloudinary.uploader().destroy(CloudinaryImageHelper.getImagePublicIdFromUrl(url), ObjectUtils.emptyMap());
        } catch (IOException e) {
            return new ErrorResult(e.getMessage());
        }
        return new SuccessResult("Image deleted");
    }
}
