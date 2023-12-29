package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.exceptions.DataNotFoundException;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
import com.tobeto.rentacar.entities.concretes.Brand;
import com.tobeto.rentacar.entities.concretes.Customer;
import com.tobeto.rentacar.repository.CustomerRepository;
import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.dtos.requests.customer.CreateCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.customer.DeleteCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.customer.UpdateCustomerRequests;
import com.tobeto.rentacar.services.dtos.responses.brand.GetAllBrandResponses;
import com.tobeto.rentacar.services.dtos.responses.customer.GetAllCustomerResponses;
import com.tobeto.rentacar.services.dtos.responses.customer.GetByIdCustomerResponses;
import com.tobeto.rentacar.services.rules.CustomerBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;
    private CustomerBusinessRules customerBusinessRules;

    @Override
    public DataResult<List<GetAllCustomerResponses>> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<GetAllCustomerResponses> getAllCustomerResponses = customers.stream()
                .map(customer -> this.modelMapperService.forResponse()
                        .map(customer, GetAllCustomerResponses.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllCustomerResponses, true, "Customers listed");
    }

    @Override
    public DataResult<GetByIdCustomerResponses> getById(int id) {
        Customer customers = customerRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Data not found.") {
        });
        GetByIdCustomerResponses getByIdCustomerResponses = this.modelMapperService.forResponse()
                .map(customers, GetByIdCustomerResponses.class);

        return new DataResult<>(getByIdCustomerResponses, true, "Customer listed");
    }

    @Override
    public Result add(CreateCustomerRequests createCustomerRequests) {

        this.customerBusinessRules.checkIfCustomerExists(createCustomerRequests.getNationalityId());

        Customer customer = new Customer();
        customer.setNationalityId(createCustomerRequests.getNationalityId());

        this.customerRepository.save(customer);

        return new SuccessResult("Customer added");
    }

    @Override
    public Result update(UpdateCustomerRequests updateCustomerRequests) {

        Customer customer = this.modelMapperService.forRequest()
                .map(updateCustomerRequests, Customer.class);
        customer.setNationalityId(updateCustomerRequests.getNationalityId());

        this.customerRepository.save(customer);

        return new Result(true, "Customer updated");
    }

    @Override
    public Result delete(DeleteCustomerRequests deleteCustomerRequests) {
        Customer customer = this.modelMapperService.forRequest()
                .map(deleteCustomerRequests, Customer.class);
        this.customerRepository.delete(customer);

        return new Result(true, "Customer deleted");
    }

    @Override
    public List<GetAllCustomerResponses> findByNationalityId(String nationalityId) {
        List<Customer> customers = customerRepository.findByNationalityId(nationalityId);
        List<GetAllCustomerResponses> responseList = new ArrayList<>();

        for (Customer customer : customers) {
            responseList.add(new GetAllCustomerResponses(customer.getNationalityId()));
        }
        return responseList;
    }

    @Override
    public List<GetAllCustomerResponses> findByNationalityIdStartingWith(String nationalityId) {
        List<Customer> customers = customerRepository.findByNationalityIdStartingWith(nationalityId);
        List<GetAllCustomerResponses> responseList = new ArrayList<>();

        for (Customer customer : customers
        ) {
            responseList.add(new GetAllCustomerResponses(customer.getNationalityId()));

        }
        return responseList;
    }

    @Override
    public List<GetAllCustomerResponses> findByNationalityIdEndingWith(String nationalityId) {
        List<Customer> customers = customerRepository.findByNationalityIdEndingWith(nationalityId);
        List<GetAllCustomerResponses> responseList = new ArrayList<>();

        for (Customer customer : customers) {
            responseList.add(new GetAllCustomerResponses(customer.getNationalityId()));
        }
        return responseList;
    }

    @Override
    public List<GetAllCustomerResponses> findByNationalityIdContaining(String nationalityId) {
        List<Customer> customers = customerRepository.findByNationalityIdContaining(nationalityId);
        List<GetAllCustomerResponses> responseList = new ArrayList<>();

        for (Customer customer : customers) {
            responseList.add(new GetAllCustomerResponses(customer.getNationalityId()));
        }
        return responseList;
    }


}
