package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    boolean existsByPlate(String plate);

    List<Car> findByYear(int year);

    List<Car> findByPlate(String plate);

}
