package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByGsm(String gsm);

}
