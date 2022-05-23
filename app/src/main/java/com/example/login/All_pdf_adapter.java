package com.example.login;


import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Random;


public class All_pdf_adapter extends FirebaseRecyclerAdapter<uploadpdf, All_pdf_adapter.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    Context context;
    boolean canDeleteItem;
    public All_pdf_adapter(@NonNull FirebaseRecyclerOptions<uploadpdf> options, Context context, boolean canDeleteItem) {
        super(options);
        this.context=context;
        this.canDeleteItem = canDeleteItem;
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull uploadpdf model) {
        holder.pdfname.setText(model.getPdfname());
        holder.pdfname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setType("*/*");
                    intent.setData(Uri.parse(model.getPdfurl()));
                    context.startActivity(intent);
                    context.startActivity(intent);
            }
        });

    }

//    private void goToURL(String URI)
//    {
//        Intent intent=new Intent(Intent.ACTION_VIEW);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.setType("*/*");
//        intent.setData(Uri.parse(URI));
//        context.startActivity(intent);
//        context.startActivity(intent);
//    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        if (canDeleteItem) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teacher_course_pdf,parent,false);
        }
        else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_enrolled_course_pdf,parent,false);
        }

        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView pdfname;
        ImageView pdf_image;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            pdf_image = (ImageView) itemView.findViewById(R.id.dummy_image);
            if (canDeleteItem) {
                pdfname = (TextView) itemView.findViewById(R.id.teacher_course_pdfname);
            }
            else {
                pdfname = (TextView) itemView.findViewById(R.id.student_enrolled_course_pdfname);
            }
        }
    }
}
