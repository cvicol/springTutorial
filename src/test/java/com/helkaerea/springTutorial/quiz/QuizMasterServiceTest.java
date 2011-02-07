package com.helkaerea.springTutorial.quiz;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuizMasterServiceTest {
    private static QuizMasterService quizMaster;
    public static final String SPRING_QUESTION = "Are you new at Spring?";
    public static final String STRUTZ_QUESTION = "Are you new at Strutz?";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    @BeforeClass
    public static void before(){
        ApplicationContext context = new ClassPathXmlApplicationContext("appl-context.xml");        
        quizMaster = (QuizMasterService) context.getBean("quizMasterService");
    }
    @Before
    public void beforeEach() {
        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void shouldSetAQuizMaster() throws Exception {
        Assert.assertNotNull(quizMaster.getQuizMaster());
    }
    @Test
    public void shouldPrintASpringQuizMasterQuestion() throws Exception {
        quizMaster.askQuestion();
        Assert.assertNotNull(outContent);
        Assert.assertEquals(SPRING_QUESTION, outContent.toString().replaceAll("\\n", ""));
    }
    @Test
    public void shouldPrintAStrutzQuizMasterQuestion() throws Exception {
        quizMaster.setQuizMaster(new StrutzQuizMaster());
        quizMaster.askQuestion();
        Assert.assertNotNull(outContent);
        Assert.assertEquals(STRUTZ_QUESTION, outContent.toString().replaceAll("\\n", ""));
    }
    
    @After
    public void afterEach(){
      System.setOut(null);        
    }
    
}
