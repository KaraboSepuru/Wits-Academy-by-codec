package com.example.login;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    public module testing = new module("STAT2006","Mathematical Statistics 2","Mr Sergio Giavani", 2.0f);
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