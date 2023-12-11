package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
