package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.TextView;

public class WeekContent extends AppCompatActivity {
    TextView weeknumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_content);
        getWindow().setStatusBarColor(ContextCompat.getColor(WeekContent.this, R.color.teal_700));

        weeknumber=findViewById(R.id.week_number);
        String weeknumber1=getIntent().getStringExtra("week_number").toString();
    }
}