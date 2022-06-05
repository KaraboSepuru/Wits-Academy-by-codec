package com.example.login;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.content.Context;
import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class TeacherCoursesInstrumentedTest {
    @Rule
    public ActivityScenarioRule<TeacherCourses> activityScenarioRule = new ActivityScenarioRule<>(TeacherCourses.class);
    private ActivityScenario<TeacherCourses> scenario = null;

    @Before
    public void setUp() throws Exception {
        scenario = activityScenarioRule.getScenario();
    }

    @Test
    public void testLaunch(){
        onView(withId(R.id.recylerview_teacher_courses)).check(new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                // check if activity launches correctly
                // by checking if the view recycler_teacher_courses is null
                Assert.assertNotNull(view);

            }
        });
    }

    @After
    public void tearDown() throws Exception {
        scenario = null;
    }
}