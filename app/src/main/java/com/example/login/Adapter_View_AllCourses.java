package com.example.login;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.Random;

public class Adapter_View_AllCourses extends FirebaseRecyclerAdapter<module, Adapter_View_AllCourses.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    Context context;
    public Adapter_View_AllCourses(@NonNull FirebaseRecyclerOptions<module> options, Context context) {
        super(options);
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull module model) {
        holder.name.setText(model.getModCode());
        holder.course.setText(model.getModName());
        holder.email.setText(model.getModTeacher());

        Random rand = new Random();
        int randomNum = rand.nextInt((4 - 0) + 1) + 0;

        switch (randomNum){
            case 0:
                holder.imageView.setImageResource(R.drawable.course0);
                break;
            case 1:
                holder.imageView.setImageResource(R.drawable.course1);
                break;
            case 2:
                holder.imageView.setImageResource(R.drawable.course2);
                break;
            case 3:
                holder.imageView.setImageResource(R.drawable.course3);
                break;
            case 4:
                holder.imageView.setImageResource(R.drawable.courses);
                break;
        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,CourseContent.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("course_name",holder.name.getText().toString());
                intent.putExtra("course_teacher",holder.email.getText().toString());
                context.startActivity(intent);
            }
        });

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_rc,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView name,course,email;
        ImageView imageView;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.nametext2);
            course = (TextView)itemView.findViewById(R.id.coursetext2);
            email = (TextView)itemView.findViewById(R.id.emailtext2);
            imageView=(ImageView)itemView.findViewById(R.id.image_view);
        }
    }
}
