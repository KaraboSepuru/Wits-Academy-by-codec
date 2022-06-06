package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Forum extends AppCompatActivity {
    Button askquestion;
    RecyclerView recyclerView;
    each_question_adapter mainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        askquestion=findViewById(R.id.ask_question);

        recyclerView = (RecyclerView)findViewById(R.id.recycle_question);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //String coursecode=getIntent().getStringExtra("course_code");
        String coursecode="COMSTRYING1018";


        FirebaseRecyclerOptions<model_posting_question> options =
                new FirebaseRecyclerOptions.Builder<model_posting_question>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Forum").child(coursecode), model_posting_question.class)
                        .build();
        mainAdapter = new each_question_adapter(options,getApplicationContext(),coursecode);
        recyclerView.setAdapter(mainAdapter);

        askquestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Forum.this,type_question.class);
                intent.putExtra("course_code",coursecode);
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