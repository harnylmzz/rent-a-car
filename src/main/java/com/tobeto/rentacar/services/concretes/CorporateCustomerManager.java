package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.CorporateCustomer;
import com.tobeto.rentacar.repository.CorporateCustomerRepository;
import com.tobeto.rentacar.services.abstracts.CorporateCustomerService;
import com.tobeto.rentacar.services.dtos.requests.corporateCustomer.CreateCorporateCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.corporateCustomer.DeleteCorporateCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.corporateCustomer.UpdateCorporateCustomerRequests;
import com.tobeto.rentacar.services.dtos.responses.corporateCustomer.GetAllCorporateCustomer;
import com.tobeto.rentacar.services.dtos.responses.corporateCustomer.GetByIdCorporateCustomer;
import com.tobeto.rentacar.services.messages.corporateCustomer.CorporateCustomerMessages;
import com.tobeto.rentacar.services.rules.corporateCustomer.CorporateCustomerBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CorporateCustomerManager implements CorporateCustomerService {

    private final CorporateCustomerRepository corporateCustomerRepository;
    private final ModelMapperService modelMapperService;
    private final PasswordEncoder passwordEncoder;
    private final CorporateCustomerBusinessRules corporateCustomerBusinessRules;

    @Override
    public DataResult<List<GetAllCorporateCustomer>> getAll() {

        List<CorporateCustomer> corporateCustomers = corporateCustomerRepository.findAll();
        List<GetAllCorporateCustomer> getAllCorporateCustomers = corporateCustomers.stream()
                .map(corporateCustomer -> this.modelMapperService.forResponse()
                        .map(corporateCustomer, GetAllCorporateCustomer.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllCorporateCustomers, true, CorporateCustomerMessages.CORPORATE_CUSTOMERS_LISTED);
    }

    @Override
    public DataResult<GetByIdCorporateCustomer> getById(int id) {

        CorporateCustomer corporateCustomer = corporateCustomerRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(CorporateCustomerMessages.CORPORATE_CUSTOMER_NOT_FOUND));

        GetByIdCorporateCustomer getByIdCorporateCustomer = this.modelMapperService.forResponse()
                .map(corporateCustomer, GetByIdCorporateCustomer.class);

        return new DataResult<>(getByIdCorporateCustomer, true, CorporateCustomerMessages.CORPORATE_CUSTOMERS_LISTED);
    }

    @Override
    public Result add(CreateCorporateCustomerRequests createCorporateCustomerRequests) {

        this.corporateCustomerBusinessRules.checkIfTaxNumber(createCorporateCustomerRequests.getTaxNumber());
        this.corporateCustomerBusinessRules.checkIfCompanyName(createCorporateCustomerRequests.getCompanyName());

        createCorporateCustomerRequests.setPassword(passwordEncoder.encode(createCorporateCustomerRequests.getPassword()));

        CorporateCustomer corporateCustomer = this.modelMapperService.forRequest()
                .map(createCorporateCustomerRequests, CorporateCustomer.class);

        this.corporateCustomerRepository.save(corporateCustomer);

        return new SuccessResult(CorporateCustomerMessages.CORPORATE_CUSTOMER_ADDED);
    }

    @Override
    public Result update(UpdateCorporateCustomerRequests updateCorporateCustomerRequests) {

        CorporateCustomer corporateCustomer = this.modelMapperService.forRequest()
                .map(updateCorporateCustomerRequests, CorporateCustomer.class);

        corporateCustomer.setId(updateCorporateCustomerRequests.getId());
        corporateCustomer.setCompanyName(updateCorporateCustomerRequests.getCompanyName());
        corporateCustomer.setTaxNumber(updateCorporateCustomerRequests.getTaxNumber());

        this.corporateCustomerRepository.save(corporateCustomer);

        return new SuccessResult(CorporateCustomerMessages.CORPORATE_CUSTOMER_UPDATED);
    }

    @Override
    public Result delete(DeleteCorporateCustomerRequests deleteCorporateCustomerRequests) {

        CorporateCustomer corporateCustomer = this.modelMapperService.forRequest()
                .map(deleteCorporateCustomerRequests, CorporateCustomer.class);

        this.corporateCustomerRepository.delete(corporateCustomer);

        return new SuccessResult(CorporateCustomerMessages.CORPORATE_CUSTOMER_DELETED);
    }
}
