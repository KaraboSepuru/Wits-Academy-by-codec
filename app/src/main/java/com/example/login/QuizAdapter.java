package com.example.login;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Random;

public class QuizAdapter extends FirebaseRecyclerAdapter<quizModel, QuizAdapter.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    Context context;
    String which;
    public QuizAdapter(@NonNull FirebaseRecyclerOptions<quizModel> options, Context context,String which) {
        super(options);
        this.context=context;
        this.which=which;
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull quizModel model) {
        holder.questionNumberTV.setText("Question");
        holder.quetionTV.setText(model.getQuestion());
        holder.opt1Btn.setText(model.getOpt1());
        holder.opt2Btn.setText(model.getOpt2());
        holder.opt3Btn.setText(model.getOpt3());
        holder.opt4Btn.setText(model.getOpt4());

        holder.opt1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.opt2Btn.setEnabled(false);
                holder.opt3Btn.setEnabled(false);
                holder.opt4Btn.setEnabled(false);
                if(holder.opt1Btn.getText().toString().equals(model.getAns())){
                    Toast.makeText(context, "Your answer is correct!!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "WRONG", Toast.LENGTH_SHORT).show();
                }

            }

        });

        holder.opt2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.opt1Btn.setEnabled(false);
                holder.opt3Btn.setEnabled(false);
                holder.opt4Btn.setEnabled(false);
                if(holder.opt2Btn.getText().toString().equals(model.getAns())){
                    Toast.makeText(context, "Your answer is correct!!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "WRONG", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.opt3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.opt1Btn.setEnabled(false);
                holder.opt2Btn.setEnabled(false);
                holder.opt4Btn.setEnabled(false);
                if(holder.opt3Btn.getText().toString().equals(model.getAns())){
                    Toast.makeText(context, "Your answer is correct!!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "WRONG", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.opt4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.opt2Btn.setEnabled(false);
                holder.opt3Btn.setEnabled(false);
                holder.opt1Btn.setEnabled(false);
                if(holder.opt4Btn.getText().toString().equals(model.getAns())){
                    Toast.makeText(context, "Your answer is correct!!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "WRONG", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_add_quiz,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView questionNumberTV,quetionTV;
        Button opt1Btn, opt2Btn, opt3Btn, opt4Btn;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            questionNumberTV = (TextView)itemView.findViewById(R.id.questionNumberTV);
            quetionTV = (TextView)itemView.findViewById(R.id.questionTV);
            opt1Btn = (Button)itemView.findViewById(R.id.optOneBtn);
            opt2Btn = (Button)itemView.findViewById(R.id.optTwoBtn);
            opt3Btn = (Button)itemView.findViewById(R.id.optThreeBtn);
            opt4Btn = (Button)itemView.findViewById(R.id.optFourBtn);
        }
    }
}

