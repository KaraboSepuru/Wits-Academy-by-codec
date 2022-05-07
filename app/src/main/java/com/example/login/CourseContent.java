package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class CourseContent extends AppCompatActivity {
    TextView coursename,coursedesc,courseinst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_course_content);
        getWindow().setStatusBarColor(ContextCompat.getColor(CourseContent.this, R.color.teal_700));

        courseinst=findViewById(R.id.instructor_name);
        coursename=findViewById(R.id.course_name);
        coursedesc=findViewById(R.id.course_description);

        String coursename1=getIntent().getStringExtra("course_name").toString();
        String courseinstructor=getIntent().getStringExtra("course_teacher").toString();

        courseinst.setText(courseinstructor);
        coursename.setText(coursename1);
        coursedesc.setText("The Computer Science curriculum includes a software design component that is aligned with the\n" +
                "recommendations prescribed by the ACM and IEEE organisations1\n" +
                ". This alignment is different\n" +
                "from what would be covered in a typical software engineering degree as it is more focused on\n" +
                "those aspects of software engineering deemed essential to a computer scientist.");

    }
}