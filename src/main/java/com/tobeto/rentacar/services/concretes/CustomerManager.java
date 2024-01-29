package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.Customer;
import com.tobeto.rentacar.repository.CustomerRepository;
import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.dtos.requests.customer.CreateCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.customer.DeleteCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.customer.UpdateCustomerRequests;
import com.tobeto.rentacar.services.dtos.responses.customer.GetAllCustomerResponses;
import com.tobeto.rentacar.services.dtos.responses.customer.GetByIdCustomerResponses;
import com.tobeto.rentacar.services.constans.customer.CustomerMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllCustomerResponses>> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<GetAllCustomerResponses> getAllCustomerResponses = customers.stream()
                .map(customer -> this.modelMapperService.forResponse()
                        .map(customer, GetAllCustomerResponses.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllCustomerResponses, true, CustomerMessages.CUSTOMERS_LISTED);
    }

    @Override
    public DataResult<GetByIdCustomerResponses> getById(int id) {
        Customer customers = customerRepository.findById(id).orElseThrow(() -> new DataNotFoundException(CustomerMessages.CUSTOMER_NOT_FOUND) {
        });
        GetByIdCustomerResponses getByIdCustomerResponses = this.modelMapperService.forResponse()
                .map(customers, GetByIdCustomerResponses.class);

        return new DataResult<>(getByIdCustomerResponses, true, CustomerMessages.CUSTOMERS_LISTED);
    }

    @Override
    public Result add(CreateCustomerRequests createCustomerRequests) {

        Customer customer = this.modelMapperService.forRequest()
                .map(createCustomerRequests, Customer.class);

        this.customerRepository.save(customer);

        return new SuccessResult(CustomerMessages.CUSTOMER_ADDED);
    }

    @Override
    public Result update(UpdateCustomerRequests updateCustomerRequests) {

        Customer customer = this.modelMapperService.forRequest()
                .map(updateCustomerRequests, Customer.class);

        this.customerRepository.save(customer);

        return new Result(true, CustomerMessages.CUSTOMER_UPDATED);
    }

    @Override
    public Result delete(DeleteCustomerRequests deleteCustomerRequests) {
        Customer customer = this.modelMapperService.forRequest()
                .map(deleteCustomerRequests, Customer.class);
        this.customerRepository.delete(customer);

        return new Result(true, CustomerMessages.CUSTOMER_DELETED);
    }
}
