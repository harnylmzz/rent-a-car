package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsByName(String name);
    List<Brand> findByName(String name);
    List<Brand> findByNameContaining(String name);
    List<Brand> findByNameStartingWith(String name);
    List<Brand> findByNameEndingWith(String name);
}
