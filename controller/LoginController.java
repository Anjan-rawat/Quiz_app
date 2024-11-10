package com.anjan.quiz.controller;

import com.anjan.quiz.dto.LoginRequest;
import com.anjan.quiz.entity.QuizQuestion;
import com.anjan.quiz.service.QuestionService;
import com.anjan.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public LoginRequest signup(@RequestBody LoginRequest loginRequest) {
        return userService.saveData(loginRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        userService.loginUser(loginRequest);  // This method will throw if there's an error
        return ResponseEntity.ok("Login successfully");
    }

    @PostMapping("/forget-password")
    public String forgetPassword(@RequestBody LoginRequest loginRequest){
        return userService.forgetPassword(loginRequest);
    }

    @GetMapping("/java-questions")
    public List<QuizQuestion> getJavaQuestions() {
        return questionService.getJavaQuestions();
    }

    @GetMapping("/python-questions")
    public List<QuizQuestion> getPyQuestions() {
        return questionService.getPyQuestions();
    }

    @GetMapping("/js-questions")
    public List<QuizQuestion> getJsQuestions() {
        return questionService.getJsQuestions();
    }

    @GetMapping("/net-questions")
    public List<QuizQuestion> getNetQuestions() {
        return questionService.getNetQuestions();
    }

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public QuizQuestion saveQuestion(@RequestBody QuizQuestion question) {
        return questionService.saveQuestion(question);
    }

}