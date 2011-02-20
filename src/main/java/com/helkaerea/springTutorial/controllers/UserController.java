package com.helkaerea.springTutorial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.helkaerea.springTutorial.user.User;
import com.helkaerea.springTutorial.user.UserService;

@Controller
@RequestMapping("/userRegistration.html")
@SessionAttributes("user")
public class UserController{
    
    private UserService userService;
 
       
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String showUserForm(ModelMap model) {
        User user = new User();
        model.addAttribute(user);
        return "userRegistration";        
    }
    
    @RequestMapping(method = RequestMethod.POST)
     public String onSubmit(@ModelAttribute("user") User user) {
         userService.addUser(user);
         return "redirect:userSuccess.html";
      }
         
}
