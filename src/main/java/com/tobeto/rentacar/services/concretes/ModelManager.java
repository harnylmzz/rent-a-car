package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.Model;
import com.tobeto.rentacar.repository.ModelRepository;
import com.tobeto.rentacar.services.abstracts.ModelService;
import com.tobeto.rentacar.services.dtos.requests.model.CreateModelRequests;
import com.tobeto.rentacar.services.dtos.requests.model.DeleteModelRequests;
import com.tobeto.rentacar.services.dtos.requests.model.UpdateModelRequests;
import com.tobeto.rentacar.services.dtos.responses.model.GetAllModelResponses;
import com.tobeto.rentacar.services.dtos.responses.model.GetByIdModelResponses;
import com.tobeto.rentacar.services.rules.ModelBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    private ModelBusinessRules modelBusinessRules;

    @Override
    public DataResult<List<GetAllModelResponses>> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelResponses> getAllModelResponses = models.stream()
                .map(model -> this.modelMapperService.forResponse()
                        .map(model, GetAllModelResponses.class))
                .collect(Collectors.toList());
        return new DataResult<>(getAllModelResponses, true, "Models listed");
    }

    @Override
    public DataResult<GetByIdModelResponses> getById(int id) {
        Model model = modelRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Data not found.") {
        });
        GetByIdModelResponses getByIdModelResponses = this.modelMapperService.forResponse()
                .map(model, GetByIdModelResponses.class);
        return new DataResult<>(getByIdModelResponses, true, "Model listed");
    }

    @Override
    public Result add(CreateModelRequests createModelRequests) {

        this.modelBusinessRules.checkIfName(createModelRequests.getName());

        Model model = this.modelMapperService.forRequest()
                .map(createModelRequests, Model.class);
        this.modelRepository.save(model);

        return new SuccessResult("Model added");
    }

    @Override
    public Result update(UpdateModelRequests updateModelRequests) {
        Model model = this.modelMapperService.forRequest()
                .map(updateModelRequests, Model.class);
        model.setId(updateModelRequests.getId());
        model.setName(updateModelRequests.getName());
        this.modelRepository.save(model);

        return new SuccessResult("Model updated");
    }

    @Override
    public Result delete(DeleteModelRequests deleteModelRequests) {
        Model model = this.modelMapperService.forRequest()
                .map(deleteModelRequests, Model.class);
        this.modelRepository.delete(model);

        return new SuccessResult("Model deleted");
    }
}
