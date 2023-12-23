package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.config.modelmapper.ModelMapperService;
import com.tobeto.rentacar.core.result.DataResult;
import com.tobeto.rentacar.core.result.Result;
import com.tobeto.rentacar.core.result.SuccessResult;
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
        Customer customers = customerRepository.findById(id).orElseThrow();
        GetByIdCustomerResponses getByIdCustomerResponses = this.modelMapperService.forResponse()
                .map(customers, GetByIdCustomerResponses.class);

        return new DataResult<>(getByIdCustomerResponses, true, "Customer listed");
    }

    @Override
    public Result add(CreateCustomerRequests createCustomerRequests) {

        Customer customer = new Customer();
        customer.setNationalityId(createCustomerRequests.getNationalityId());
        customer.setFirstName(createCustomerRequests.getFirstName());
        customer.setLastName(createCustomerRequests.getLastName());
        customer.setEmail(createCustomerRequests.getEmail());
        customer.setGsm(createCustomerRequests.getGsm());

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
}
