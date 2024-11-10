package com.anjan.quiz.service;

import com.anjan.quiz.dto.LoginRequest;
import com.anjan.quiz.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepo userRepo;

    public LoginRequest saveData(LoginRequest loginRequest){
        LoginRequest save = userRepo.save(loginRequest);
        return save;
    }

    public void loginUser(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        Optional<LoginRequest> byEmailAndPassword = userRepo.findByEmailAndPassword(email, password);
        if(byEmailAndPassword.isEmpty()){
            throw new IllegalArgumentException("Invalid email or password");
        }
    }

    public String forgetPassword(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        Optional<LoginRequest> passwordByEmail = userRepo.findPasswordByEmail(email);
        if(passwordByEmail.isPresent()) {
            LoginRequest loginRequest1 = passwordByEmail.get();
            return loginRequest1.getPassword();
        }
        else
            throw new IllegalArgumentException("Invalid email");
    }
}
