package com.example.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Teacher_New_Module extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST=1;
    EditText modName;
    EditText modCode;
    EditText modTeach,imagename;
    Button createMod,chooseim,uploadim;
    ProgressBar progressBar;
    ImageView viewimage;
    private Uri mImageUri;
    FirebaseAuth mAuth;
    DatabaseReference databaseReference,databaseReference1;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_new_module);
        getWindow().setStatusBarColor(ContextCompat.getColor(Teacher_New_Module.this, R.color.teal_700));

        bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.add_module);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.teacher_courses:
                    startActivity(new Intent(Teacher_New_Module.this,TeacherCourses.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.add_module:
                    return true;
                case R.id.teacher_account:
                    startActivity(new Intent(Teacher_New_Module.this,TeacherAccount.class));
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });

        modName = findViewById(R.id.moduleName);
        modCode = findViewById(R.id.moduleCode);
        modTeach = findViewById(R.id.moduleTName);
        createMod = findViewById(R.id.createCourse);
        chooseim=findViewById(R.id.choose_image_to_upload);
        uploadim=findViewById(R.id.upload_image);
        imagename=findViewById(R.id.image_name);
        viewimage=findViewById(R.id.view_image_before_upload);
        progressBar=findViewById(R.id.progress_bar_upload_image);

        mAuth = FirebaseAuth.getInstance();

        createMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createModule();
                modName.setText("");
                modCode.setText("");
                modTeach.setText("");
            }
        });
        
        uploadim.setEnabled(false);
        chooseim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagename.setText("");
                //chooseImage();
            }
        });
        
        uploadim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //uploadimage();
            }
        });
        
        
    }
    private String getFileExtension(Uri uri){
        ContentResolver cR=getContentResolver();
        MimeTypeMap mime=MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void uploadimage() {
        if(mImageUri!=null){
            StorageReference filereference= FirebaseStorage.getInstance().getReference("Cover Images")
                    .child(modCode+" "+getFileExtension(mImageUri));
            filereference.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Handler handler=new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(0);
                        }
                    },500);
                    Toast.makeText(Teacher_New_Module.this, "Upload successful", Toast.LENGTH_LONG).show();
                    Upload upload=new Upload(imagename.getText().toString().trim(),taskSnapshot.toString());
                    //FirebaseDatabase.getInstance().getReference("Cover Images").child(modCode.getText().toString()).setValue(upload);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Teacher_New_Module.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                    double progress=(100.0*snapshot.getBytesTransferred()/snapshot.getTotalByteCount());
                    progressBar.setProgress((int) progress);
                }
            });
        }else{
            Toast.makeText(Teacher_New_Module.this, "No fil selected", Toast.LENGTH_SHORT).show();
        }
    }

    private void chooseImage() {
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE_REQUEST);
        
        uploadim.setEnabled(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            mImageUri=data.getData();

            viewimage.setImageURI(mImageUri);
            Toast.makeText(Teacher_New_Module.this,mImageUri.toString(),Toast.LENGTH_SHORT).show();
        }
    }

    public void createModule(){
        String mName = modName.getText().toString().trim();
        String mCode = modCode.getText().toString().trim();
        String mTeach = modTeach.getText().toString().trim();

        if(TextUtils.isEmpty(mName)){
            modName.setError("Course name cannot be empty");
            modName.requestFocus();
        }else if(TextUtils.isEmpty(mCode)){
            modCode.setError("Course code cannot be empty");
            modCode.requestFocus();
        }else if(TextUtils.isEmpty(mTeach)){
            modTeach.setError("Instructors name cannot be empty");
            modTeach.requestFocus();
        }else{
            databaseReference = FirebaseDatabase.getInstance().getReference().child("All Courses");
            module Module = new module(mName, mCode, mTeach);
            databaseReference.child(mCode).setValue(Module);
            Toast.makeText(Teacher_New_Module.this, "Course created", Toast.LENGTH_SHORT).show();

            databaseReference1 = FirebaseDatabase.getInstance().getReference().child("Group by teachers");
            module Module1 = new module(mName, mCode, mTeach);
            databaseReference1.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(mCode).setValue(Module1);

        }
    }
}