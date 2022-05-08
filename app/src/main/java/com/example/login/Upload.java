package com.example.login;

public class Upload {
    String name,imageurl;
    public Upload(){

    }
    public Upload(String name, String imageurl){
        this.name=name;
        this.imageurl=imageurl;
    }

    public String getName(){
        return name;
    }
    public String getImageurl(){
        return imageurl;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setImageulr(String imageurl){
        this.imageurl=imageurl;
    }
}
