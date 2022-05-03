package com.example.login;

public class User {
    private String fullName, occupation, email;

    public User (){
    }

    public User(String fullName, String occupation, String email){
        this.fullName = fullName;
        this.occupation = occupation;
        this.email = email;
    }

    public void setFullName(String fullName) { this.fullName = fullName;}
    public void setOccupation(String occupation) { this.occupation = occupation;}
    public void setFullEmail(String email) { this.email = email;}

    public String getFullName() { return this.fullName;}
    public String getOccupation() { return this.occupation;}
    public String getFullEmail() { return this.email;}
}
