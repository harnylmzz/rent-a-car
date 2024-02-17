package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.Car;
import com.tobeto.rentacar.services.dtos.responses.car.GetAllCarResponses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    boolean existsByPlate(String plate);

    List<Car> findByYear(int year);

    List<Car> findByPlate(String plate);

    List<Car> findByGearType(String gearType);

    List<Car> findByKilometer(int kilometer);

    List<Car> findByPrice(double price);

    List<Car> findByCategoryId(int categoryId);

    List<Car> findByColorId(int colorId);

}
