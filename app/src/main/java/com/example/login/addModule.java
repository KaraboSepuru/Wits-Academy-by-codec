package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addModule extends AppCompatActivity {

    protected EditText modName;
    protected EditText modCode;
    protected EditText modTeach;
    protected Button createMod;
    protected FirebaseAuth mAuth;
    protected DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_module);

        modName = findViewById(R.id.moduleName);
        modCode = findViewById(R.id.moduleCode);
        modTeach = findViewById(R.id.moduleTName);
        createMod = findViewById(R.id.createCourse);

        mAuth=FirebaseAuth.getInstance();

        createMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createModule();
            }
        });

    }

    public void createModule(){
        String mName = modName.getText().toString().trim();
        String mCode = modCode.getText().toString().trim();
        String mTeach = modTeach.getText().toString().trim();

        if(TextUtils.isEmpty(mName)){
            modName.setError("Course name cannot be empty");
            modName.requestFocus();
        }else if(TextUtils.isEmpty(mCode)){
            modCode.setError("Course code cannot be empty");
            modCode.requestFocus();
        }else if(TextUtils.isEmpty(mTeach)){
            modTeach.setError("Instructors name cannot be empty");
            modTeach.requestFocus();
        }else {
            databaseReference = FirebaseDatabase.getInstance().getReference().child("Courses");
            module Module = new module(mName, mCode, mTeach);
            databaseReference.push().setValue(Module);
            Toast.makeText(addModule.this, "Course created", Toast.LENGTH_SHORT).show();
        }
    }
}