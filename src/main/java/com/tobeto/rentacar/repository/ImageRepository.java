package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {

 List<Image> findByUrl(String url);
}
