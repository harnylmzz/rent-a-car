package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.requests.brand.CreateBrandRequests;
import com.tobeto.rentacar.services.dtos.requests.brand.DeleteBrandRequests;
import com.tobeto.rentacar.services.dtos.requests.brand.UpdateBrandRequests;
import com.tobeto.rentacar.services.dtos.responses.brand.GetAllBrandResponses;
import com.tobeto.rentacar.services.dtos.responses.brand.GetByIdBrandResponses;

import java.util.List;

public interface BrandService {
    List<GetAllBrandResponses> getAll();
    GetByIdBrandResponses getById(int id);
    void add(CreateBrandRequests createBrandRequests);
    void update(UpdateBrandRequests updateBrandRequests);
    void delete(DeleteBrandRequests deleteBrandRequests);
}
