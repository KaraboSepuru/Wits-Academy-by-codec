package com.example.login;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class quizModelTest {
    quizModel model1, model2;

    @Before
    public void setUp() throws Exception
    {
        model1 = new quizModel(
                "What is life?",
                "Love", "Happiness", "Family", "Consciousness",
                "Consciousness");
        model2 = new quizModel(
                "Is it possible to know if an omnibenevolent god exists?",
                "Yes", "No", "What is omnibenevolent?", "Perhaps",
                "What is omnibenevolent?");

    }

    @Test
    public void isQuestionCorrect()
    {
        Assert.assertEquals(model1.getQuestion(), "What is life?");
        Assert.assertEquals(model2.getQuestion(), "Is it possible to know if an omnibenevolent god exists?");
    }

    @Test
    public void isOpt1Correct()
    {
        Assert.assertEquals(model1.getOpt1(), "Love");
        Assert.assertEquals(model2.getOpt1(), "Yes");
    }

    @Test
    public void isOpt2Correct()
    {
        Assert.assertEquals(model1.getOpt2(), "Happiness");
        Assert.assertEquals(model2.getOpt2(), "No");
    }

    @Test
    public void isOpt3Correct()
    {
        Assert.assertEquals(model1.getOpt3(), "Family");
        Assert.assertEquals(model2.getOpt3(), "What is omnibenevolent?");
    }

    @Test
    public void isOpt4Correct()
    {
        Assert.assertEquals(model1.getOpt4(), "Consciousness");
        Assert.assertEquals(model2.getOpt4(), "Perhaps");
    }

    @Test
    public void isAnswerCorrect()
    {
        Assert.assertEquals(model1.getAns(), "Consciousness");
        Assert.assertEquals(model2.getAns(), "What is omnibenevolent?");
        Assert.assertNotEquals(model1.getAns(), "Love");
        Assert.assertNotEquals(model2.getAns(), "No");
    }

    @After
    public void tearDown() throws Exception
    {
        model1 = null;
        model2 = null;
    }
}
