package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.repository.ColorRepository;
import com.tobeto.rentacar.services.abstracts.ColorService;
import com.tobeto.rentacar.services.dtos.requests.color.CreateColorRequests;
import com.tobeto.rentacar.services.dtos.requests.color.DeleteColorRequests;
import com.tobeto.rentacar.services.dtos.requests.color.UpdateColorRequests;
import com.tobeto.rentacar.services.dtos.responses.color.GetAllColorResponses;
import com.tobeto.rentacar.services.dtos.responses.color.GetByIdColorResponses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {
    private ColorRepository colorRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllColorResponses> getAll() {
        return null;
    }

    @Override
    public GetByIdColorResponses getById(int id) {
        return null;
    }

    @Override
    public void add(CreateColorRequests createColorRequests) {

    }

    @Override
    public void update(UpdateColorRequests updateColorRequests) {

    }

    @Override
    public void delete(DeleteColorRequests deleteColorRequests) {

    }
}
