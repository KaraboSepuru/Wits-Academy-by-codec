package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class CourseContent extends AppCompatActivity {
    TextView coursename,coursedesc,courseinst,coursecode;
    Button subscribe;
    Boolean subscribed=false;
    String coursename1,courseinstructor,coursecode1,courseid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_course_content);
        getWindow().setStatusBarColor(ContextCompat.getColor(CourseContent.this, R.color.teal_700));

        courseinst=findViewById(R.id.instructor_name);
        coursename=findViewById(R.id.course_name);
        coursedesc=findViewById(R.id.course_description);
        subscribe=findViewById(R.id.subscribe);

        coursename1=getIntent().getStringExtra("course_name");
        courseinstructor=getIntent().getStringExtra("course_teacher");
        coursecode1=getIntent().getStringExtra("course_code");
        courseid=getIntent().getStringExtra("course_id");

        courseinst.setText(courseinstructor);
        coursename.setText(coursename1);

        coursedesc.setText("The Computer Science curriculum includes a software design component that is aligned with the\n" +
                "recommendations prescribed by the ACM and IEEE organisations1\n" +
                ". This alignment is different\n" +
                "from what would be covered in a typical software engineering degree as it is more focused on\n" +
                "those aspects of software engineering deemed essential to a computer scientist.");

        subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!subscribed){

                    module module=new module(coursename1,coursecode1,courseinstructor);
                    FirebaseDatabase.getInstance().getReference("Enrol")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .child(coursecode1)
                            .setValue(module)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(CourseContent.this,"Successfully subscribed to the course",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                    subscribe.setText("Subscribed");
                    subscribed=true;
                }else{
                    Toast.makeText(CourseContent.this,"Already subscribed to the course",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(this, Student_Dashboard.class));
        finish();
    }
}