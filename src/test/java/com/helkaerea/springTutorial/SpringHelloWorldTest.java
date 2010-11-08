package com.helkaerea.springTutorial;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class SpringHelloWorldTest {
       
    /**
     * Rigorous Test :-)
     */
	private static SpringHelloWorld hello;
	
	@BeforeClass
	public static void getTheContext(){
		ApplicationContext context = new ClassPathXmlApplicationContext("appl-context.xml");
		hello = (SpringHelloWorld) context.getBean("helloWorld");
	}
	
	@Test
	public void theValueOfTheMessageRecievesDefaltValueIfNoMessageIsSupplied(){		
		assertNotNull(hello.getMessage());
		assertEquals(hello.getMessage(), SpringHelloWorld.DEFAULT_GREETING_MESSAGE);
	}
	
	@Test
    public void theValueOfTheMessageIsSetToTheDesiredValue() {
        String message = "This is a first spring message";        
        hello.setMessage(message);
        assertEquals(message, hello.getMessage());        
    }
}
