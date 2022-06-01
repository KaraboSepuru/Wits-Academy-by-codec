package com.example.login;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class moduleTest {

    public module testing = new module("STAT2006","Mathematical Statistics 2","Mr Sergio Giavani", 2.0f);

    @Test
    public void testIsModCodCorrect(){
        Assert.assertEquals(testing.getModCode(),"STAT2006");
    }
    @Test
    public void testIsModNameCorrect(){
        Assert.assertEquals(testing.getModName(),"Mathematical Statistics 2");
    }
    @Test
    public void testIsModTeacherCorrect(){
        Assert.assertEquals(testing.getModTeacher(), "Mr Sergio Giavani");
    }
}
