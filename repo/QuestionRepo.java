package com.anjan.quiz.repo;

import com.anjan.quiz.entity.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<QuizQuestion,Long> {

    // Native SQL query to find java questions
    @Query(value = "SELECT * FROM quiz_question WHERE id BETWEEN 1 AND 10", nativeQuery = true)
    List<QuizQuestion> findJavaQuestion();

    @Query(value = "SELECT * FROM quiz_question WHERE id BETWEEN 11 AND 20", nativeQuery = true)
    List<QuizQuestion> findPyQuestion();

    @Query(value = "SELECT * FROM quiz_question WHERE id BETWEEN 21 AND 30", nativeQuery = true)
    List<QuizQuestion> findJsQuestion();

    @Query(value = "SELECT * FROM quiz_question WHERE id BETWEEN 31 AND 40", nativeQuery = true)
    List<QuizQuestion> findNetQuestion();
}
