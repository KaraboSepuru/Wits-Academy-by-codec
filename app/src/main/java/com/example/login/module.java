package com.example.login;

import android.widget.RatingBar;

public class module {
    private String modName, modCode, modTeacher;
    private float rating;
// hello world
//    ijfnvodfoiwdm
    module (){


    }

    module(String modCode, String modName, String modTeacher, float rating){
        this.modCode = modName;
        this.modName = modCode;
        this.modTeacher = modTeacher;
        this.rating = rating;
    }

    public float getRatingNum(){return rating;}

    public void setRatingNum(int num){
        this.rating = num;
    }

    public String getModName() {
        return modName;
    }

    public String getModCode() {
        return modCode;
    }

    public String getModTeacher() {
        return modTeacher;
    }

    public void setModName(String modName) {
        this.modName = modName;
    }

    public void setModCode(String modCode) {
        this.modCode = modCode;
    }

    public void setModTeacher(String modTeacher) {
        this.modTeacher = modTeacher;
    }
}
