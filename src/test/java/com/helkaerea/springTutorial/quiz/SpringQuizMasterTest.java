package com.helkaerea.springTutorial.quiz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.helkaerea.springTutorial.quiz.SpringQuizMaster;

public class SpringQuizMasterTest{
    public static final String SPRING_QUESTION = "Are you new at Spring?";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final SpringQuizMaster springQuizMaster = new SpringQuizMaster();
    
    @Before
    public void beforeEach() {        
        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void shouldPopASpringQuestion() throws Exception {
        springQuizMaster.popQuestion();
        assertNotNull(outContent);
        assertEquals(SPRING_QUESTION, outContent.toString().replaceAll("\\n", ""));
    }
    
    @After
    public void afterEach() {        
        System.setOut(null);
    }
}
