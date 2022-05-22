package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class createQuiz extends AppCompatActivity {
    EditText addQuestion, addResponse, addOpt1, addOpt2, addOpt3, addOpt4;
    public ArrayList<quizModel>  quizModelArrayList;
    Button addToList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);

        addQuestion = findViewById(R.id.createQuestion);
        addResponse = findViewById(R.id.createResponse);
        addOpt1 = findViewById(R.id.createOption1);
        addOpt2 = findViewById(R.id.createOption2);
        addOpt3 = findViewById(R.id.createOption3);
        addOpt4 = findViewById(R.id.createOption4);

        addToList = findViewById(R.id.addQuestionBtn);

        String question ="what is cgv?"; //addQuestion.getText().toString();
        String response = addResponse.getText().toString();
        System.out.println(response);
        String option1 = addOpt1.getText().toString();
        String option2 = addOpt2.getText().toString();
        String option3 = addOpt3.getText().toString();
        String option4 = addOpt4.getText().toString();

        quizModelArrayList = new ArrayList<>();


        addToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Questions").child("COMS1016").child("QuizOne");
                quizModel QuizQ = new quizModel(question, option1, option2, option3, option4, response);

                databaseReference.setValue(QuizQ);

            }
        });


    }
}