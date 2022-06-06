package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class inside_question extends AppCompatActivity {
    RecyclerView recyclerView;
    each_reply_adapter mainAdapter;
    Button button,go_back;
    TextView email,heading,question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_question);
        email=findViewById(R.id.inside_who_created_question);
        heading=findViewById(R.id.inside_heading_for_each_question);
        question=findViewById(R.id.inside_question_content);
        go_back=findViewById(R.id.inside_question_go_back);

        String questioncontent=getIntent().getStringExtra("question");
        String headingcontent=getIntent().getStringExtra("heading");
        String emailcontent=getIntent().getStringExtra("email");
        String coursecode=getIntent().getStringExtra("course_code");

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(inside_question.this,Forum.class);
                intent.putExtra("course_code",coursecode);
                startActivity(intent);
            }
        });

        email.setText(emailcontent);
        heading.setText(headingcontent);
        question.setText(questioncontent);

        recyclerView = (RecyclerView)findViewById(R.id.recyler_replys);
        button=findViewById(R.id.reply_to_question);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model_reply_question> options =
                new FirebaseRecyclerOptions.Builder<model_reply_question>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("ForumAnswers").child(coursecode).child(questioncontent), model_reply_question.class)
                        .build();
        mainAdapter = new each_reply_adapter(options);
        recyclerView.setAdapter(mainAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(inside_question.this,reply_question.class);
                intent.putExtra("course_code",coursecode);
                intent.putExtra("question",questioncontent);
                intent.putExtra("email",emailcontent);
                intent.putExtra("heading",headingcontent);

                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter.stopListening();
    }
}