package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.Brand;
import com.tobeto.rentacar.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    boolean existsByNationalityId(String nationalityId);
    List<Customer> findByNationalityId(String nationalityId);
    List<Customer> findByNationalityIdContaining(String nationalityId);
    List<Customer> findByNationalityIdStartingWith(String nationalityId);
    List<Customer> findByNationalityIdEndingWith(String nationalityId);
   
}
