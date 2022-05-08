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
import com.google.firebase.auth.FirebaseAuth;

import java.util.Random;

public class Student_enrolled_view_content_adapter extends FirebaseRecyclerAdapter<uploadpdf, Student_enrolled_view_content_adapter.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    String url;
    Context context;
    public Student_enrolled_view_content_adapter(@NonNull FirebaseRecyclerOptions<uploadpdf> options, Context context) {
        super(options);
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull uploadpdf uploadpdf) {
        holder.pdfname.setText(uploadpdf.getPdfname());
        holder.pdfname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,PdfContent.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("pdf_url",uploadpdf.getPdfurl());
                context.startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_enrolled_course_pdf,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView pdfname;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            pdfname = (TextView)itemView.findViewById(R.id.student_enrolled_course_pdfname);
        }
    }
}
