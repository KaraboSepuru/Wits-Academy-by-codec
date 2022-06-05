package com.example.login;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

public class moduleTest {

    private module testing;


    @Before
    public void setUp()
    {
        testing = new module("STAT2006","Mathematical Statistics 2","Mr Sergio Giavani", 2.0f);
    }

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
    @Test
    public void testIsRatingCorrect()
    {
        Assert.assertEquals(testing.getRatingNum(), 2.0f, 0f);
    }
}
