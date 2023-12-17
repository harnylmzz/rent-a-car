package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.entities.Color;
import com.tobeto.rentacar.repository.ColorRepository;
import com.tobeto.rentacar.services.abstracts.ColorService;
import com.tobeto.rentacar.services.dtos.requests.color.CreateColorRequests;
import com.tobeto.rentacar.services.dtos.requests.color.DeleteColorRequests;
import com.tobeto.rentacar.services.dtos.requests.color.UpdateColorRequests;
import com.tobeto.rentacar.services.dtos.responses.color.GetAllColorResponses;
import com.tobeto.rentacar.services.dtos.responses.color.GetByIdColorResponses;
import com.tobeto.rentacar.services.rules.ColorBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {
    private ColorRepository colorRepository;
    private ModelMapperService modelMapperService;
    private ColorBusinessRules colorBusinessRules;

    @Override
    public List<GetAllColorResponses> getAll() {
        List<Color> colors = colorRepository.findAll();
        List<GetAllColorResponses> getAllColorResponses = colors.stream()
                .map(color -> this.modelMapperService.forResponse()
                        .map(color, GetAllColorResponses.class))
                .collect(Collectors.toList());
        return getAllColorResponses;
    }

    @Override
    public GetByIdColorResponses getById(int id) {
        Color color = colorRepository.findById(id).orElseThrow();
        GetByIdColorResponses getByIdColorResponses = this.modelMapperService.forResponse()
                .map(color, GetByIdColorResponses.class);

        return getByIdColorResponses;
    }

    @Override
    public void add(CreateColorRequests createColorRequests) {

        this.colorBusinessRules.checkIfName(createColorRequests.getName());

        Color color = this.modelMapperService.forRequest()
                .map(createColorRequests, Color.class);
        this.colorRepository.save(color);

    }

    @Override
    public void update(UpdateColorRequests updateColorRequests) {
        Color color = this.modelMapperService.forRequest()
                .map(updateColorRequests, Color.class);
        color.setId(updateColorRequests.getId());
        color.setName(updateColorRequests.getName());

        this.colorRepository.save(color);
    }

    @Override
    public void delete(DeleteColorRequests deleteColorRequests) {
        Color color = this.modelMapperService.forRequest()
                .map(deleteColorRequests, Color.class);
        this.colorRepository.delete(color);
    }
}
