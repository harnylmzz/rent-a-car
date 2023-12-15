package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {

    boolean existsByPlate(String plate);
}
