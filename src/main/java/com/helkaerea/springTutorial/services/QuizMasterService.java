package com.helkaerea.springTutorial.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.helkaerea.springTutorial.quiz.QuizMaster;

public class QuizMasterService {
    private QuizMaster quizMaster;
    
    @Autowired    
    public void setQuizMaster(QuizMaster quizMaster) {
        this.quizMaster = quizMaster;
    }

    public QuizMaster getQuizMaster() {
        return quizMaster;
    }
    
    public void askQuestion() {
        this.getQuizMaster().popQuestion();
    }
}
