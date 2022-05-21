package com.example.login;

import android.widget.RatingBar;

public class module {
    private String modName, modCode, modTeacher;
    private float ratingNum;
// hello world
//    ijfnvodfoiwdm
    module (){


    }

    module(String modCode, String modName, String modTeacher, float ratingNum){
        this.modCode = modName;
        this.modName = modCode;
        this.modTeacher = modTeacher;
        this.ratingNum = ratingNum;
    }

    public float getRatingNum(){return ratingNum;}

    public void setRatingNum(int num){
        ratingNum = num;
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
