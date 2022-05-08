package com.example.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class TeacherCourse_content extends AppCompatActivity {
    TextView coursename,courseinst;
    EditText coursedesc,editText;
    String coursename1,courseinstructor,coursecode1,courseid;
    Button uploadpdf,choosepdf;
    RecyclerView recyclerView;
    All_pdf_adapter mainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_course_content);

        courseinst=findViewById(R.id.instructor_name);
        coursename=findViewById(R.id.course_name);
        coursedesc=findViewById(R.id.edit_course_desc);
        editText=findViewById(R.id.pdf_name);
        choosepdf=findViewById(R.id.choose_pdf_from_file);
        uploadpdf=findViewById(R.id.upload_pdf);

        coursename1=getIntent().getStringExtra("course_name");
        courseinstructor=getIntent().getStringExtra("course_teacher");
        coursecode1=getIntent().getStringExtra("course_code");

        courseinst.setText(courseinstructor);
        coursename.setText(coursecode1);

        uploadpdf.setEnabled(false);
        choosepdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPDF();
            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.course_pdfs);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        retrievepdf();
    }
    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(this, TeacherCourses.class));
        finish();
    }

    private void retrievepdf() {
        FirebaseRecyclerOptions<uploadpdf> options =
                new FirebaseRecyclerOptions.Builder<uploadpdf>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Course Material").child(coursename1), uploadpdf.class)//.orderByChild("modName").equalTo("APHY8010")
                        .build();
        mainAdapter = new All_pdf_adapter(options,getApplicationContext());
        recyclerView.setAdapter(mainAdapter);
    }

    private void selectPDF() {
        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"PDF FILE SELECt"),12);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==12 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            uploadpdf.setEnabled(true);
            editText.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));

            uploadpdf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    uploadPDFFileFirebase(data.getData());
                }
            });
        }else{
            Toast.makeText(TeacherCourse_content.this, "", Toast.LENGTH_SHORT).show();
        }
    }

    private void uploadPDFFileFirebase(Uri data){
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("File is loading.....");
        progressDialog.show();

        StorageTask<UploadTask.TaskSnapshot> reference= FirebaseStorage.getInstance().getReference("Lecture_Notes").child(coursecode1)
                .putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> uriTask=taskSnapshot.getStorage().getDownloadUrl();
                        while (!uriTask.isComplete());
                        Uri uri=uriTask.getResult();

                        uploadpdf uploadpdf=new uploadpdf(editText.getText().toString(),uri.toString());
                        FirebaseDatabase.getInstance().getReference("Course Material")
                                .child(coursename1)
                                .child(uploadpdf.getPdfname())
                                .setValue(uploadpdf);
                        editText.setText("");
                        Toast.makeText(TeacherCourse_content.this, "File Uploaded", Toast.LENGTH_SHORT).show();


                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        double progress=(100.0*snapshot.getBytesTransferred())/snapshot.getTotalByteCount();
                        progressDialog.setMessage("File Uploading..."+(int)progress+"%");
                    }
                });


    }

    @Override
    protected void onStart(){
        super.onStart();
        mainAdapter.startListening();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user==null){
            startActivity(new Intent(TeacherCourse_content.this,login.class));
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter.stopListening();
    }
}