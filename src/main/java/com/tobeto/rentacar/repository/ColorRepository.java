package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Integer> {

    boolean existsByName(String name);
}
