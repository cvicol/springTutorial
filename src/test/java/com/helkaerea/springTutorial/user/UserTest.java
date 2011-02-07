package com.helkaerea.springTutorial.user;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserTest {
    private static final String INITIAL_NAME = "Eric";
    private static final int INITIAL_AGE = 15;
    private static final String INITIAL_COUNTRY = "Romania";
    public static final String NULL_STRING = null;
    public static final int WEIRD_AGE = -15;
    private static final String EMPTY_STRING = " ";
    
    private static User user;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
   
    @BeforeClass
    public static void beforeClass() {
        ApplicationContext context = new ClassPathXmlApplicationContext("appl-context.xml");        
        user = (User) context.getBean("user");    
    }
    @Before
    public void beforeEach() {
        System.setOut(new PrintStream(outContent));
    }
    
    @Test
    public void userShouldHaveAName() throws Exception {
        Assert.assertNotNull(user.getName());
        Assert.assertEquals(INITIAL_NAME, user.getName());
    }
    @Test(expected= IllegalArgumentException.class)
    public void userShouldNotBeAbleNothaveANameNull() {
       user.setName(null);       
    }
    @Test(expected= IllegalArgumentException.class)
    public void userShouldNotBeAbleNothaveANameEmpty() {
       user.setName(" ");       
    }
    @Test(expected= IllegalArgumentException.class)
    public void userShouldNotBeAbleNothaveACountryNull() {
       user.setCountry(NULL_STRING);       
    }
    @Test(expected= IllegalArgumentException.class)
    public void userShouldNotBeAbleNothaveACountryEmpty() {
       user.setCountry(EMPTY_STRING);       
    }
    @Test(expected= IllegalArgumentException.class)
    public void userShouldNotBeAbleNothaveAFunnehAge() {
       user.setAge(WEIRD_AGE);       
    }
    @Test
    public void userShouldHaveAnAge() throws Exception {
        Assert.assertThat(user.getAge(),Matchers.is(INITIAL_AGE));
    }
    @Test
    public void userShouldHaveAnCountry() throws Exception {
        Assert.assertThat(user.getCountry(),Matchers.is(INITIAL_COUNTRY));
    }
    @After
    public void afterEach() {
        System.setOut(null);
    }
}
