package com.anjan.quiz.service;

import com.anjan.quiz.entity.QuizQuestion;
import com.anjan.quiz.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    public List<QuizQuestion> getJavaQuestions()
    {
        List<QuizQuestion> questionRepoAll = questionRepo.findJavaQuestion();
        return questionRepoAll;
    }

    public List<QuizQuestion> getPyQuestions()
    {
        return questionRepo.findPyQuestion();
    }

    public List<QuizQuestion> getJsQuestions()
    {
        return questionRepo.findJsQuestion();
    }

    public List<QuizQuestion> getNetQuestions()
    {
        return questionRepo.findNetQuestion();
    }

    public QuizQuestion saveQuestion(QuizQuestion question){
        QuizQuestion save = questionRepo.save(question);
        return save;
    }

}