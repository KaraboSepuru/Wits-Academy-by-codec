package com.example.login;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

public class UserTest {

    User user = new User("abc123", "hello@gmail.com");

    @Test
    public void testIsEmailCorrect()
    {
        Assert.assertEquals(user.getEmail(), "hello@gmail.com");
    }
    @Test
    public void testIsPasswordCorrect()
    {
        Assert.assertEquals(user.getPassword(), "abc123");
    }
}
