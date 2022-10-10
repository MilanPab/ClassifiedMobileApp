package com.example.classifiedappmain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class postyourbusiness extends AppCompatActivity {

    private EditText businessNameEdit,locationEdit,emailEdit,phoneEdit,websiteEdit,photosUrlEdit,ScheduleEdit;
    Button submitPost,click;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private String postID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postyourbusiness);

        businessNameEdit = findViewById(R.id.businessName);
        locationEdit = findViewById(R.id.location);
        emailEdit = findViewById(R.id.email);
        phoneEdit = findViewById(R.id.phone);
        websiteEdit = findViewById(R.id.website);
        photosUrlEdit = findViewById(R.id.photos);
        ScheduleEdit = findViewById(R.id.schedule);


        submitPost = findViewById(R.id.submit);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Business");



        submitPost.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast.makeText(postyourbusiness.this, "Button Clicked", Toast.LENGTH_SHORT).show();
                processInsert();


                }
        });

    }

    private void processInsert() {

        Map<String,Object> map = new HashMap<>();
        map.put("businessname",businessNameEdit.getText().toString());
        map.put("location",locationEdit.getText().toString());
        map.put("email",emailEdit.getText().toString());
        map.put("phone",phoneEdit.getText().toString());
        map.put("website",websiteEdit.getText().toString());
        map.put("photosUrl",photosUrlEdit.getText().toString());
        map.put("Schedule",ScheduleEdit.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("listing").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        businessNameEdit.setText("");
                        locationEdit.setText("");
                        emailEdit.setText("");
                        phoneEdit.setText("");
                        websiteEdit.setText("");
                        photosUrlEdit.setText("");
                        ScheduleEdit.setText("");
                        Toast.makeText(postyourbusiness.this, "Inserted SuccessFully", Toast.LENGTH_SHORT).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        businessNameEdit.setText("");
                        locationEdit.setText("");
                        emailEdit.setText("");
                        phoneEdit.setText("");
                        websiteEdit.setText("");
                        photosUrlEdit.setText("");
                        ScheduleEdit.setText("");
                        Toast.makeText(postyourbusiness.this, "Insertation Fail: "+e, Toast.LENGTH_SHORT).show();
                    }
                });

    }
}