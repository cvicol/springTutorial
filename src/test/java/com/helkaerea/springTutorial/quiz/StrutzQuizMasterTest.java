package com.helkaerea.springTutorial.quiz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StrutzQuizMasterTest{
    public static final String STRUTZ_QUESTION = "Are you new at Strutz?";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final StrutzQuizMaster strutzQuizMaster = new StrutzQuizMaster();
    
    @Before
    public void beforeEach() {        
        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void shouldPopASpringQuestion() throws Exception {
        strutzQuizMaster.popQuestion();
        assertNotNull(outContent);
        assertEquals(STRUTZ_QUESTION, outContent.toString().replaceAll("\\n", ""));
    }
    
    @After
    public void afterEach() {        
        System.setOut(null);
    }
}
