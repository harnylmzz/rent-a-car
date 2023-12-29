package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.services.dtos.requests.color.CreateColorRequests;
import com.tobeto.rentacar.services.dtos.requests.color.DeleteColorRequests;
import com.tobeto.rentacar.services.dtos.requests.color.UpdateColorRequests;
import com.tobeto.rentacar.services.dtos.responses.color.GetAllColorResponses;
import com.tobeto.rentacar.services.dtos.responses.color.GetByIdColorResponses;

import java.util.List;

public interface ColorService {
    DataResult<List<GetAllColorResponses>> getAll();

    DataResult<GetByIdColorResponses> getById(int id);

    Result add(CreateColorRequests createColorRequests);

    Result update(UpdateColorRequests updateColorRequests);

    Result delete(DeleteColorRequests deleteColorRequests);

    List<GetAllColorResponses> findByName(String name);

    List<GetAllColorResponses> findByNameStartingWith(String name);

    List<GetAllColorResponses> findByNameContaining(String name);
}
