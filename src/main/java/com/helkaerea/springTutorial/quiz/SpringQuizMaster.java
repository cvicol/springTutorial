package com.helkaerea.springTutorial.quiz;

import org.springframework.stereotype.Component;

@Component
public class SpringQuizMaster implements QuizMaster {
    public static final String SPRING_QUESTION = "Are you new at Spring?";
    
    public SpringQuizMaster() {
     //default constructor   
    }
    public void popQuestion() {
       System.out.println(SPRING_QUESTION);        
    }
}
