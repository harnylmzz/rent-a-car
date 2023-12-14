package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.entities.Model;
import com.tobeto.rentacar.repository.ModelRepository;
import com.tobeto.rentacar.services.abstracts.ModelService;
import com.tobeto.rentacar.services.dtos.requests.model.CreateModelRequests;
import com.tobeto.rentacar.services.dtos.requests.model.DeleteModelRequests;
import com.tobeto.rentacar.services.dtos.requests.model.UpdateModelRequests;
import com.tobeto.rentacar.services.dtos.responses.model.GetAllModelResponses;
import com.tobeto.rentacar.services.dtos.responses.model.GetByIdModelResponses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllModelResponses> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelResponses> getAllModelResponses = models.stream()
                .map(model -> this.modelMapperService.forResponse().map(model, GetAllModelResponses.class))
                .collect(Collectors.toList());
        return getAllModelResponses;
    }

    @Override
    public GetByIdModelResponses getById(int id) {
        Model model = modelRepository.findById(id).orElseThrow();
        GetByIdModelResponses getByIdModelResponses = this.modelMapperService.forResponse().map(model, GetByIdModelResponses.class);
        return getByIdModelResponses;
    }

    @Override
    public void add(CreateModelRequests createModelRequests) {
        Model model = this.modelMapperService.forRequest()
                .map(createModelRequests , Model.class);
        this.modelRepository.save(model);

    }

    @Override
    public void update(UpdateModelRequests updateModelRequests) {
        Model model = this.modelMapperService.forRequest()
                .map(updateModelRequests , Model.class);
        model.setId(updateModelRequests.getId());
        model.setName(updateModelRequests.getName());
        this.modelRepository.save(model);
    }

    @Override
    public void delete(DeleteModelRequests deleteModelRequests) {
        Model model = this.modelMapperService.forRequest()
                .map(deleteModelRequests , Model.class);
        this.modelRepository.delete(model);
    }
}
