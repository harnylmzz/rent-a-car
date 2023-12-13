package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.requests.customer.CreateCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.customer.DeleteCustomerRequests;
import com.tobeto.rentacar.services.dtos.requests.customer.UpdateCustomerRequests;
import com.tobeto.rentacar.services.dtos.responses.customer.GetAllCustomerResponses;
import com.tobeto.rentacar.services.dtos.responses.customer.GetByIdCustomerResponses;

import java.util.List;

public interface CustomerService {
    List<GetAllCustomerResponses> getAll();
    GetByIdCustomerResponses getById(int id);
    void add(CreateCustomerRequests createCustomerRequests);
    void update(UpdateCustomerRequests updateCustomerRequests);
    void delete(DeleteCustomerRequests deleteCustomerRequests);
}
