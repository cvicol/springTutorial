package com.helkaerea.springTutorial.quiz;


public class StrutzQuizMaster implements QuizMaster {

    private static final String STRUTZ_QUESTION = "Are you new at Strutz?";

    @Override
    public void popQuestion() {
        System.out.println(STRUTZ_QUESTION);        
    }
    
}
