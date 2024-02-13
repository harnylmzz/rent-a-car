package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.controller.BrandsController;
import com.tobeto.rentacar.entities.concretes.Brand;
import com.tobeto.rentacar.entities.concretes.Category;
import com.tobeto.rentacar.services.dtos.responses.category.GetAllCategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    boolean existsByName(String name);

    List<Category> findByName(String name);
    List<Category> findByNameContaining(String name);
    List<Category> findByNameStartingWith(String name);
    List<Category> findByNameEndingWith(String name);
}
