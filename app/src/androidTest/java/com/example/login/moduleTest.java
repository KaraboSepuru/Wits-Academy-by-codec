package com.example.login;

import org.junit.Assert;
import org.junit.Test;

public class moduleTest {

    public module testing = new module("STAT2006","Mathematical Statistics 2","Mr Sergio Giavani");

    @Test
    public void testIsModCodCorrect(){

        Assert.assertEquals(testing.getModName(),"STAT2006");

    }
    @Test
    public void testIsModNameCorrect(){
        Assert.assertEquals(testing.getModCode(),"Mathematical Statistics 2");
    }
    @Test
    public void testIsModTeacherCorrect(){
        Assert.assertEquals(testing.getModTeacher(), "Mr Sergio Giavani");
    }
}
