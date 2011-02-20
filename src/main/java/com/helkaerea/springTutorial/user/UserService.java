package com.helkaerea.springTutorial.user;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    
//    private User user;
//    
//    @Autowired
//    public UserService(User user) {
//        this.user = user;
//    }
//    public User getUser() {        
//        return user;
//    }
    public void addUser(User userTest) {
        System.out.println("added an user :" + userTest.showFullDescription());        
    }
    
}
