package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {


    boolean existsById(int id);

    List<Rental> findByStartDate(LocalDate startDate);

    List<Rental> findByEndDate(LocalDate endDate);

    List<Rental> findByReturnDate(LocalDate returnDate);

    List<Rental> findByStartKilometer(int startKilometer);

    List<Rental> findByEndKilometer(int endKilometer);

    List<Rental> findByTotalPrice(double totalPrice);

    List<Rental> findByDiscount(double discount);

}

