package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class announcement extends AppCompatActivity {

    Button btnPost;
    EditText postMessage;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);
        btnPost = findViewById(R.id.btnPost);
        postMessage = findViewById(R.id.postTxt);


        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inp = postMessage.getText().toString().trim();
                post obj = new post(inp);
                String coursecode=getIntent().getStringExtra("course_code");
                databaseReference = FirebaseDatabase.getInstance().getReference().child("Announcements");
                databaseReference.child(coursecode).setValue(obj);
                Toast.makeText(announcement.this,"Announcement made",Toast.LENGTH_SHORT).show();
                postMessage.setText("");
            }
        });

    }
}