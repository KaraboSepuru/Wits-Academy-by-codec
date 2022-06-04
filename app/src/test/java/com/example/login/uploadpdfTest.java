package com.example.login;

import org.junit.Assert;
import org.junit.Test;

public class uploadpdfTest {
    uploadpdf uploadLove = new uploadpdf("Love", "www.love.com");
    uploadpdf uploadHate = new uploadpdf("Hate", "www.hate.com");

    @Test
    public void testisPDFNameCorrect()
    {
        Assert.assertEquals(uploadLove.getPdfname(), "Love");
        Assert.assertEquals(uploadHate.getPdfname(), "Hate");
    }

    public void testisPDFURLCorrect()
    {
        Assert.assertEquals(uploadLove.getPdfurl(), "www.love.com");
        Assert.assertEquals(uploadHate.getPdfurl(), "www.hate.com");
    }
}
