package com.tobeto.rentacar.repository;

import com.tobeto.rentacar.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);

    boolean existsByGsm(String gsm);

    List<User> findByFirstName(String firstName);

    List<User> findByLastName( String lastName);

    List<User> findByEmail(String email);

    List<User> findByGsm(String gsm);


}
