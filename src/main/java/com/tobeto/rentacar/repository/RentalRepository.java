package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

    boolean existsById(int id);
}
