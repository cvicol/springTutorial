package com.helkaerea.springTutorial.user;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    private static final String FULL_CONTENT = "added an user :Eric is 15 years old and living in : Romania with pass:null with gender:null with aboutMenull with comunitynull with mailing listfalse";
    private static UserService userService;    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static User userTest = new User("Johan", 25, "Holland");
    
    @BeforeClass
    public static void before(){
        ApplicationContext context = new ClassPathXmlApplicationContext("appl-context.xml");        
        userService = (UserService) context.getBean("userService");
        userTest = (User) context.getBean("user");
    }
    
    @Before
    public void beforeEach() {
        System.setOut(new PrintStream(outContent));
    }
    
/*    @Test
    public void shouldSetAnUser() throws Exception {
        Assert.assertNotNull(userService.getUser());
        System.out.println(userService.getUser().showFullDescription());
    }*/
    
    @Test
    public void shoudlAddAnUser() throws Exception {        
        userService.addUser(userTest);
        Assert.assertNotNull(outContent);
        Assert.assertEquals(FULL_CONTENT, outContent.toString().replaceAll("\\n", ""));
    }
    @After
    public void afterEach(){
      System.setOut(null);        
    }
}
