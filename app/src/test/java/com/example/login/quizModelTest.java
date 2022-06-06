package com.example.login;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

public class quizModelTest extends TestCase {
    public quizModel testing_quizModel = new quizModel("What is CGV", "A", "B", "C", "D", " A");
    @Test
    public void testquizModela() {
        Assert.assertEquals(testing_quizModel.getQuestion(),"What is CGV");
    }
    @Test
    public void testquizModelb() {
        Assert.assertEquals(testing_quizModel.getOpt1(),"A");
    }
    @Test
    public void testquizModelc() {
        Assert.assertEquals(testing_quizModel.getOpt2(),"B");
    }
    @Test
    public void testquizModeld() {
        Assert.assertEquals(testing_quizModel.getOpt3(),"C");
    };
    @Test
    public void testquizModele() {
        Assert.assertEquals(testing_quizModel.getOpt4(),"D");
    };
    @Test
    public void testquizModelf() {
        Assert.assertEquals(testing_quizModel.getAns(),"A");
    }

}