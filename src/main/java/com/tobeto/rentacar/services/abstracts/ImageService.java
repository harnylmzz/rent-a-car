package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.entities.concretes.Image;
import com.tobeto.rentacar.services.dtos.requests.image.CreateImageRequests;
import com.tobeto.rentacar.services.dtos.requests.image.DeleteImageRequests;
import com.tobeto.rentacar.services.dtos.requests.image.UpdateImageRequests;
import com.tobeto.rentacar.services.dtos.responses.image.GetAllImageResponses;
import com.tobeto.rentacar.services.dtos.responses.image.GetByIdImageResponses;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Service interface for managing image-related operations.
 * Defines methods for retrieving, adding, updating, and deleting images.
 * Uses Data Transfer Objects (DTOs) for requests and responses.
 * Provides both individual and list-based retrieval of image information.
 * Supports CRUD (Create, Read, Update, Delete) operations for images.
 *
 * @author [Harun Yılmaz]
 **/

public interface ImageService {

    DataResult<Object> save(MultipartFile file, int carId);

    Result delete(String url);

    List<GetAllImageResponses> findByUrl(String url);

}
