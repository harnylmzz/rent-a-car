package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.entities.Customer;
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
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllCustomerResponses> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<GetAllCustomerResponses> getAllCustomerResponses = customers.stream()
                .map(customer -> this.modelMapperService.forResponse()
                        .map(customer, GetAllCustomerResponses.class))
                .collect(Collectors.toList());

        return getAllCustomerResponses;
    }

    @Override
    public GetByIdCustomerResponses getById(int id) {
        Customer customers = customerRepository.findById(id).orElseThrow();
        GetByIdCustomerResponses getByIdCustomerResponses = this.modelMapperService.forResponse()
                .map(customers, GetByIdCustomerResponses.class);

        return getByIdCustomerResponses;
    }

    @Override
    public void add(CreateCustomerRequests createCustomerRequests) {
        Customer customer = this.modelMapperService.forRequest()
                .map(createCustomerRequests, Customer.class);
        this.customerRepository.save(customer);
    }

    @Override
    public void update(UpdateCustomerRequests updateCustomerRequests) {
        Customer customer = this.modelMapperService.forRequest()
                .map(updateCustomerRequests, Customer.class);
        customer.setId(updateCustomerRequests.getId());
        customer.setNationalityId(updateCustomerRequests.getNationalityId());
        this.customerRepository.save(customer);
    }

    @Override
    public void delete(DeleteCustomerRequests deleteCustomerRequests) {
        Customer customer = this.modelMapperService.forRequest()
                .map(deleteCustomerRequests, Customer.class);
        this.customerRepository.delete(customer);
    }
}
