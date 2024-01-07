package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
