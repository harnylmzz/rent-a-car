package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.IndividualCustomer;
import com.tobeto.rentacar.repository.IndividualCustomerRepository;
import com.tobeto.rentacar.services.abstracts.IndividualCustomerService;
import com.tobeto.rentacar.services.dtos.requests.individualCustomer.CreateIndividualCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.individualCustomer.DeleteIndividualCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.individualCustomer.UpdateIndividualCustomerRequests;
import com.tobeto.rentacar.services.dtos.responses.individualCustomer.GetAllIndividualCustomerResponses;
import com.tobeto.rentacar.services.dtos.responses.individualCustomer.GetByIdIndividualCustomerResponses;
import com.tobeto.rentacar.services.constans.individualCustomer.IndividualCustomerMessages;
import com.tobeto.rentacar.services.rules.individualCustomer.IndividualCustomerBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {

    private final IndividualCustomerRepository individualCustomerRepository;
    private final ModelMapperService modelMapperService;
    private final PasswordEncoder passwordEncoder;
    private final IndividualCustomerBusinessRules individualCustomerBusinessRules;

    @Override
    public DataResult<List<GetAllIndividualCustomerResponses>> getAll() {

        List<IndividualCustomer> individualCustomers = individualCustomerRepository.findAll();
        List<GetAllIndividualCustomerResponses> getAllIndividualCustomerResponses = individualCustomers.stream()
                .map(individualCustomer -> this.modelMapperService.forResponse()
                        .map(individualCustomer, GetAllIndividualCustomerResponses.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllIndividualCustomerResponses, true, IndividualCustomerMessages.INDIVIDUAL_CUSTOMERS_LISTED);
    }

    @Override
    public DataResult<GetByIdIndividualCustomerResponses> getById(int id) {

        IndividualCustomer individualCustomer = individualCustomerRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Data not found."));

        GetByIdIndividualCustomerResponses getByIdIndividualCustomerResponses = this.modelMapperService.forResponse()
                .map(individualCustomer, GetByIdIndividualCustomerResponses.class);

        return new DataResult<>(getByIdIndividualCustomerResponses, true, IndividualCustomerMessages.INDIVIDUAL_CUSTOMERS_LISTED);
    }

    @Override
    public Result add(CreateIndividualCustomerRequests createIndividualCustomerRequests) {

        this.individualCustomerBusinessRules.checkIfNationalityIdExists(createIndividualCustomerRequests.getNationalityId());

        createIndividualCustomerRequests.setPassword(passwordEncoder.encode(createIndividualCustomerRequests.getPassword()));

        this.individualCustomerRepository.save(this.modelMapperService.forRequest()
                .map(createIndividualCustomerRequests, IndividualCustomer.class));

        return new SuccessResult(IndividualCustomerMessages.INDIVIDUAL_CUSTOMER_ADDED);
    }

    @Override
    public Result update(UpdateIndividualCustomerRequests updateIndividualCustomerRequests) {

        IndividualCustomer individualCustomer = this.modelMapperService.forRequest()
                .map(updateIndividualCustomerRequests, IndividualCustomer.class);

        this.individualCustomerRepository.save(individualCustomer);

        return new SuccessResult(IndividualCustomerMessages.INDIVIDUAL_CUSTOMER_UPDATED);
    }

    @Override
    public Result delete(DeleteIndividualCustomerRequests deleteIndividualCustomerRequests) {

        IndividualCustomer individualCustomer = this.modelMapperService.forRequest()
                .map(deleteIndividualCustomerRequests, IndividualCustomer.class);

        this.individualCustomerRepository.delete(individualCustomer);

        return new SuccessResult(IndividualCustomerMessages.INDIVIDUAL_CUSTOMER_DELETED);
    }
}
