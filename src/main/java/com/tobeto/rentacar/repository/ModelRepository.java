package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {

    boolean existsByName(String name);
}
