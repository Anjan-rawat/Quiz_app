package com.anjan.quiz.repo;

import com.anjan.quiz.dto.LoginRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<LoginRequest,String> {

    // Custom method to find user by email and password
    Optional<LoginRequest> findByEmailAndPassword(String email, String password);
    Optional<LoginRequest> findPasswordByEmail(String email);
}
