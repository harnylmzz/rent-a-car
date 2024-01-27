package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, Integer> {

    boolean existsByTaxNumber(String taxNumber);

    boolean existsByCompanyName(String companyName);
}
