package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
