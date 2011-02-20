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
    private static final String ABOUT_YOU = "I AM AN ALIEN";
    private static final String INITIAL_PASSWORD = "test123";
    private static final String GENDER_FEMALE = "female";
    private static final String INITIAL_NAME = "Eric";
    private static final int INITIAL_AGE = 15;
    private static final String INITIAL_COUNTRY = "Romania";
    public static final String NULL_STRING = null;
    public static final int WEIRD_AGE = -15;
    private static final String EMPTY_STRING = " ";
    private static final Object USER_WITH_FULL_CONSTR = "Escher is 24 years old and living in : Netherlands";
    private static final Object USER_WITH_PARTIAL_CONSTR = "Escher is 0 years old and living in : Netherlands";
    private static final Object USER_WITH_FUNNEH_PARTIAL_CONSTR = "Escher is 24 years old and living in : null";
    private static final String[] comunity = {"AI", "Spring", "JAVA", "SCALA"};
    
    private static User user;
    private static User userWithFullConstructor;
    private static User userWithPartialConstructor;
    private static User userWithFunnyPartialConstructor;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
   
    @BeforeClass
    public static void beforeClass() {
        ApplicationContext context = new ClassPathXmlApplicationContext("appl-context.xml");        
        user = (User) context.getBean("user");
        userWithFullConstructor = (User) context.getBean("userWithFullConstructor");
        userWithFunnyPartialConstructor = (User) context.getBean("userWithFunnehPartialConstructor");
        userWithPartialConstructor = (User) context.getBean("userWithPartialConstructor");
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
    @Test
    public void shouldBeUserWithFullConstructor() throws Exception {
        Assert.assertEquals(USER_WITH_FULL_CONSTR ,userWithFullConstructor.toString());
    }
    @Test
    public void shouldBeUserWithPartialConstructor() throws Exception {
        Assert.assertEquals(USER_WITH_PARTIAL_CONSTR ,userWithPartialConstructor.toString());
    }
    @Test
    public void shouldBeUserWithFunnehPartialConstructor() throws Exception {
        Assert.assertEquals(USER_WITH_FUNNEH_PARTIAL_CONSTR ,userWithFunnyPartialConstructor.toString());
    }
    
    @Test
    public void userShouldHaveAnGenderIfSet() throws Exception {
        Assert.assertThat(user.getGender(),Matchers.is(NULL_STRING));
        user.setGender(GENDER_FEMALE);
        Assert.assertThat(user.getGender(),Matchers.is(GENDER_FEMALE));        
    }
    
    @Test
    public void userShouldHaveAnPasswordIfSet() throws Exception {
        Assert.assertThat(user.getPassword(),Matchers.is(NULL_STRING));
        user.setPassword(INITIAL_PASSWORD);
        Assert.assertThat(user.getPassword(),Matchers.is(INITIAL_PASSWORD));        
    }
    
    @Test
    public void userShouldHaveAnAboutYouIfSet() throws Exception {
        Assert.assertThat(user.getAboutYou(),Matchers.is(NULL_STRING));
        user.setAboutYou(ABOUT_YOU);
        Assert.assertThat(user.getAboutYou(),Matchers.is(ABOUT_YOU));        
    }
    
    @Test
    public void userShouldHaveAnAffiliationWithMailingList() throws Exception {
        Assert.assertFalse(user.getMailingList());
        user.setMailingList(Boolean.TRUE);
        Assert.assertTrue(user.getMailingList());        
    }
     
    @Test
    public void userShouldHaveAnAffiliationWithComunityIfSet() throws Exception {
        Assert.assertNull(user.getCommunity());
        user.setCommunity(comunity);
        Assert.assertArrayEquals(comunity, user.getCommunity());        
    }
    @After
    public void afterEach() {
        System.setOut(null);
    }
}
