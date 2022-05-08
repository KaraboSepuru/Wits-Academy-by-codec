package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Student_Dashboard extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    RecyclerView recyclerView;
    Adapter_View_AllCourses mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);
        getWindow().setStatusBarColor(ContextCompat.getColor(Student_Dashboard.this, R.color.teal_700));

        bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.dashboard);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.dashboard:
                    return true;
                case R.id.student_courses:
                    startActivity(new Intent(Student_Dashboard.this,StudentCourses.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.student_account:
                    startActivity(new Intent(Student_Dashboard.this,StudentAccount.class));
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });


        recyclerView = (RecyclerView)findViewById(R.id.recylerview_all_courses);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<module> options =
                new FirebaseRecyclerOptions.Builder<module>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("All Courses"), module.class)//.orderByChild("modName").equalTo("APHY8010")
                        .build();
        mainAdapter = new Adapter_View_AllCourses(options,getApplicationContext(),"");
        recyclerView.setAdapter(mainAdapter);

    }

    @Override
    protected void onStart(){
        super.onStart();
        mainAdapter.startListening();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user==null){
            startActivity(new Intent(Student_Dashboard.this,login.class));
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter.stopListening();
    }
}