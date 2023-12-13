package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.requests.color.CreateColorRequests;
import com.tobeto.rentacar.services.dtos.requests.color.DeleteColorRequests;
import com.tobeto.rentacar.services.dtos.requests.color.UpdateColorRequests;
import com.tobeto.rentacar.services.dtos.responses.color.GetAllColorResponses;
import com.tobeto.rentacar.services.dtos.responses.color.GetByIdColorResponses;

import java.util.List;

public interface ColorService {
    List<GetAllColorResponses> getAll();
    GetByIdColorResponses getById(int id);
    void add(CreateColorRequests createColorRequests);
    void update(UpdateColorRequests updateColorRequests);
    void delete(DeleteColorRequests deleteColorRequests);
}
