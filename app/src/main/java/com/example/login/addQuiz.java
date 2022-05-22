package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class addQuiz extends AppCompatActivity {

    private TextView questionNumberTV, questionTV;
    private Button option1Btn, option2Btn, option3Btn, option4Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quiz);

        Intent intent = new Intent(addQuiz.this, createQuiz.class);

        questionNumberTV= findViewById(R.id.questionNumberTV);
        questionTV=findViewById(R.id.questionTV);
        option1Btn=findViewById(R.id.optOneBtn);
        option2Btn=findViewById(R.id.optTwoBtn);
        option3Btn=findViewById(R.id.optThreeBtn);
        option4Btn=findViewById(R.id.optFourBtn);



    }



}