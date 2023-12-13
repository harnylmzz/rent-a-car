package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.repository.CustomerRepository;
import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.dtos.requests.customer.CreateCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.customer.DeleteCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.customer.UpdateCustomerRequests;
import com.tobeto.rentacar.services.dtos.responses.customer.GetAllCustomerResponses;
import com.tobeto.rentacar.services.dtos.responses.customer.GetByIdCustomerResponses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllCustomerResponses> getAll() {
        return null;
    }

    @Override
    public GetByIdCustomerResponses getById(int id) {
        return null;
    }

    @Override
    public void add(CreateCustomerRequests createCustomerRequests) {

    }

    @Override
    public void update(UpdateCustomerRequests updateCustomerRequests) {

    }

    @Override
    public void delete(DeleteCustomerRequests deleteCustomerRequests) {

    }
}
