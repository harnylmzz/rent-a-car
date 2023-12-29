package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.dtos.requests.brand.CreateBrandRequests;
import com.tobeto.rentacar.services.dtos.requests.brand.DeleteBrandRequests;
import com.tobeto.rentacar.services.dtos.requests.brand.UpdateBrandRequests;
import com.tobeto.rentacar.services.dtos.responses.brand.GetAllBrandResponses;
import com.tobeto.rentacar.services.dtos.responses.brand.GetByIdBrandResponses;

import java.util.List;

public interface BrandService {
    DataResult<List<GetAllBrandResponses>> getAll();

    DataResult<GetByIdBrandResponses> getById(int id);

    Result add(CreateBrandRequests createBrandRequests);

    Result update(UpdateBrandRequests updateBrandRequests);

    Result delete(DeleteBrandRequests deleteBrandRequests);

    List<GetAllBrandResponses> findByName(String name);

    List<GetAllBrandResponses> findByNameStartingWith(String name);

    List<GetAllBrandResponses> findByNameEndingWith(String name);
    List<GetAllBrandResponses> findByNameContaining(String name);


}
