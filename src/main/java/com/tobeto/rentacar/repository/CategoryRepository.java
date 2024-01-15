package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
