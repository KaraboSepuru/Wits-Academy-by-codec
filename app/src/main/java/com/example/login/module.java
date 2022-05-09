package com.example.login;

import android.widget.ImageButton;

public class module {
    String modName, modCode, modTeacher;
    ImageButton picture;

    module (){

    }

    module(String modCode, String modName, String modTeacher, ImageButton picture){
        this.picture = picture;
        this.modCode = modCode;
        this.modName = modName;
        this.modTeacher = modTeacher;
    }

    public String getModName() {
        return modName;
    }

    public ImageButton getPicture() {
        return picture;
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

    public void setPicture(ImageButton picture) {
        this.picture = picture;
    }

    public void setModCode(String modCode) {
        this.modCode = modCode;
    }

    public void setModTeacher(String modTeacher) {
        this.modTeacher = modTeacher;
    }
}
