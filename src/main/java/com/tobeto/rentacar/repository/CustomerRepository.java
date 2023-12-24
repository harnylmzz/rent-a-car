package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    boolean existsByNationalityId(String nationalityId);
}
