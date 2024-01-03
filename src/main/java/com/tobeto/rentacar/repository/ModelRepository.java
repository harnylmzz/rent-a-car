package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Integer> {

    boolean existsByName(String name);

    List<Model> findByName(String name);
}
