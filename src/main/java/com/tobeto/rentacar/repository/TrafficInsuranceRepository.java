package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.TrafficInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrafficInsuranceRepository extends JpaRepository<TrafficInsurance, Integer> {
}
