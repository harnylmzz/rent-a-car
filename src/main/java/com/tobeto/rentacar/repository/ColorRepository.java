package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Integer> {

    boolean existsByName(String name);


}
