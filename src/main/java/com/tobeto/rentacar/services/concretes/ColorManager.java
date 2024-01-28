package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.Color;
import com.tobeto.rentacar.repository.ColorRepository;
import com.tobeto.rentacar.services.abstracts.ColorService;
import com.tobeto.rentacar.services.dtos.requests.color.CreateColorRequests;
import com.tobeto.rentacar.services.dtos.requests.color.DeleteColorRequests;
import com.tobeto.rentacar.services.dtos.requests.color.UpdateColorRequests;
import com.tobeto.rentacar.services.dtos.responses.color.GetAllColorResponses;
import com.tobeto.rentacar.services.dtos.responses.color.GetByIdColorResponses;
import com.tobeto.rentacar.services.messages.color.ColorMessages;
import com.tobeto.rentacar.services.rules.color.ColorBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColorManager implements ColorService {
    private final ColorRepository colorRepository;
    private final ModelMapperService modelMapperService;
    private final ColorBusinessRules colorBusinessRules;

    @Override
    public DataResult<List<GetAllColorResponses>> getAll() {
        List<Color> colors = colorRepository.findAll();
        List<GetAllColorResponses> getAllColorResponses = colors.stream()
                .map(color -> this.modelMapperService.forResponse()
                        .map(color, GetAllColorResponses.class))
                .collect(Collectors.toList());
        return new DataResult<>(getAllColorResponses, true, ColorMessages.COLORS_LISTED);
    }

    @Override
    public DataResult<GetByIdColorResponses> getById(int id) {
        Color color = colorRepository.findById(id).orElseThrow(() -> new DataNotFoundException(ColorMessages.COLOR_NOT_FOUND) {
        });
        GetByIdColorResponses getByIdColorResponses = this.modelMapperService.forResponse()
                .map(color, GetByIdColorResponses.class);

        return new DataResult<>(getByIdColorResponses, true, ColorMessages.COLORS_LISTED);
    }

    @Override
    public Result add(CreateColorRequests createColorRequests) {

        this.colorBusinessRules.checkIfName(createColorRequests.getName());

        Color color = this.modelMapperService.forRequest()
                .map(createColorRequests, Color.class);
        this.colorRepository.save(color);

        return new SuccessResult(ColorMessages.COLOR_ADDED);

    }

    @Override
    public Result update(UpdateColorRequests updateColorRequests) {
        Color color = this.modelMapperService.forRequest()
                .map(updateColorRequests, Color.class);
        color.setId(updateColorRequests.getId());
        color.setName(updateColorRequests.getName());

        this.colorRepository.save(color);

        return new SuccessResult(ColorMessages.COLOR_UPDATED);
    }

    @Override
    public Result delete(DeleteColorRequests deleteColorRequests) {
        Color color = this.modelMapperService.forRequest()
                .map(deleteColorRequests, Color.class);
        this.colorRepository.delete(color);

        return new SuccessResult(ColorMessages.COLOR_DELETED);
    }
}
