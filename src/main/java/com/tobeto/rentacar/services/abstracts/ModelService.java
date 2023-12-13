package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.requests.model.CreateModelRequests;
import com.tobeto.rentacar.services.dtos.requests.model.DeleteModelRequests;
import com.tobeto.rentacar.services.dtos.requests.model.UpdateModelRequests;
import com.tobeto.rentacar.services.dtos.responses.model.GetAllModelResponses;
import com.tobeto.rentacar.services.dtos.responses.model.GetByIdModelResponses;

import java.util.List;

public interface ModelService {
    List<GetAllModelResponses> getAll();
    GetByIdModelResponses getById(int id);
    void add(CreateModelRequests createModelRequests);
    void update(UpdateModelRequests updateModelRequests);
    void delete(DeleteModelRequests deleteModelRequests);
}
