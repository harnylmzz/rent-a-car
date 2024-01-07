package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
}
