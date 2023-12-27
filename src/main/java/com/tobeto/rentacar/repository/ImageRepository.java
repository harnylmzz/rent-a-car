package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
