package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.Category;
import com.tobeto.rentacar.repository.CategoryRepository;
import com.tobeto.rentacar.services.abstracts.CategoryService;
import com.tobeto.rentacar.services.dtos.requests.category.CreateCategoryRequests;
import com.tobeto.rentacar.services.dtos.requests.category.DeleteCategoryRequests;
import com.tobeto.rentacar.services.dtos.requests.category.UpdateCategoryRequests;
import com.tobeto.rentacar.services.dtos.responses.category.GetAllCategoryResponse;
import com.tobeto.rentacar.services.dtos.responses.category.GetByIdCategoryResponse;
import com.tobeto.rentacar.services.messages.category.CategoryMessages;
import com.tobeto.rentacar.services.rules.CategoryBusinessRules;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryManager implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapperService modelMapperService;
    private final CategoryBusinessRules categoryBusinessRules;

    @Override
    public DataResult<List<GetAllCategoryResponse>> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<GetAllCategoryResponse> getAllCategoryResponses = categories.stream()
                .map(category -> this.modelMapperService.forResponse()
                        .map(category, GetAllCategoryResponse.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllCategoryResponses, true, CategoryMessages.CATEGORIES_LISTED);
    }

    @Override
    public DataResult<GetByIdCategoryResponse> getById(int id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new DataNotFoundException(CategoryMessages.CATEGORY_NOT_FOUND));
        GetByIdCategoryResponse getByIdCategoryResponse = this.modelMapperService.forResponse()
                .map(category, GetByIdCategoryResponse.class);

        return new DataResult<>(getByIdCategoryResponse, true, CategoryMessages.CATEGORIES_LISTED);
    }

    @Override
    public Result add(CreateCategoryRequests createCategoryRequests) {

        this.categoryBusinessRules.checkIfName(createCategoryRequests.getName());

        Category category = this.modelMapperService.forRequest()
                .map(createCategoryRequests, Category.class);
        this.categoryRepository.save(category);

        return new SuccessResult(CategoryMessages.CATEGORY_ADDED);
    }

    @Override
    public Result update(UpdateCategoryRequests updateCategoryRequests) {
        Category category = this.modelMapperService.forRequest()
                .map(updateCategoryRequests, Category.class);
        category.setId(updateCategoryRequests.getId());
        category.setName(updateCategoryRequests.getName());
        this.categoryRepository.save(category);

        return new SuccessResult(CategoryMessages.CATEGORY_UPDATED);
    }

    @Override
    public Result delete(DeleteCategoryRequests deleteCategoryRequests) {
        Category category = this.modelMapperService.forRequest()
                .map(deleteCategoryRequests, Category.class);
        this.categoryRepository.delete(category);

        return new SuccessResult(CategoryMessages.CATEGORY_DELETED);
    }
}
