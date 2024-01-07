package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
