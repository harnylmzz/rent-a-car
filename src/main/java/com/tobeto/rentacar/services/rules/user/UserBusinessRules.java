package com.tobeto.rentacar.services.rules.user;

import com.tobeto.rentacar.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBusinessRules {

    private final UserRepository userRepository;

    public void checkIfUserExists(String email, String gsm) {
        if (this.userRepository.existsByEmail(email)) {
            throw new RuntimeException("User already exists.");
        }
        if (this.userRepository.existsByGsm(gsm)) {
            throw new RuntimeException("User already exists.");
        }
    }
}
