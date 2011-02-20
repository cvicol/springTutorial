package com.helkaerea.springTutorial.user;

public class User {

    private String name;
    private int age;
    private String country;
    
    private String password;
    private String gender;    
    private String aboutYou;
    private String[] community;
    private Boolean mailingList = Boolean.FALSE;
    public User() {
        //just a default constructor
    }
        
    public User(String name, int age, String country) {
        this.setAge(age);
        this.setName(name);
        this.setCountry(country);    
    }
    
    public User(String name, String coutry) {
        this.setCountry(coutry);
        this.setName(name);
    }
    
    public User(String name, int age) {
        this.setAge(age);
        this.setName(name);
    }
    public String getName() {
       return this.name;
    }  
    public void setName(String name) {        
        if (name  == null || "".equals(name.trim())) {
           throw new IllegalArgumentException("The name cannot be null or empty!!!"); 
        }
        this.name = name;
    }
    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("The age cannot be funneh!!!"); 
         }
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setCountry(String country) {
        if (country  == null || "".equals(country.trim())) {
            throw new IllegalArgumentException("The country cannot be null or empty!!!"); 
         }
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public String toString() {
        return name + " is " + age + " years old and living in : " + country ; 
    }
    
    public String showFullDescription() {
        return  this.toString() + " with pass:" + password + " with gender:" + gender +  " with aboutMe" + aboutYou + " with comunity" + getComunityAsString() + " with mailing list" + mailingList;
    }
    
    private String getComunityAsString() {         
        return null;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }
    public void setAboutYou(String aboutYou) {
        this.aboutYou = aboutYou;
    }
    public String getAboutYou() {
        return aboutYou;
    }
    public void setCommunity(String[] community) {
        this.community = community;
    }
    public String[] getCommunity() {
        return community;
    }
    public void setMailingList(Boolean mailingList) {
        this.mailingList = mailingList;
    }
    public Boolean getMailingList() {
        return mailingList;
    }        
}
