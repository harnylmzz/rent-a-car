package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
