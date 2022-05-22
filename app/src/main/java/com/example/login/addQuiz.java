package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Random;

public class addQuiz extends AppCompatActivity {

    private TextView questionNumberTV, questionTV;
    private Button option1Btn, option2Btn, option3Btn, option4Btn;
    //public ArrayList<quizModel> quizModelArrayList;
    Random random;
    int currentScore= 0, questionAttempted =1, currentPos;

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
       // ArrayList<quizModel> quizModelArrayList = getIntent().getParcelableArrayListExtra(quizModelArrayList, quizModel);
        random=new Random();
        //getQuizQuestion(quizModelArrayList);
       // setDataToViews(currentPos);



    }

    /*private void setDataToViews(int currentPos) {
        quizModel options = FirebaseDatabase.getInstance().getReference().child("Questions").child("COMS1016").child("QuizOne");//.orderByChild("modName").equalTo("APHY8010")


        questionTV.setText(options);

        //questionTV.setText(quizModel.get(currentPos).getQuestion());

    }*/

}