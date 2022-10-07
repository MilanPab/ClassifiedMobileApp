package com.example.classifiedappmain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Contactus extends AppCompatActivity {
    Button gmail,phone,facebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        getSupportActionBar().setTitle("Contact Us");
        gmail=findViewById(R.id.contact_gmailBtn);
        phone=findViewById(R.id.contact_phoneBtn);
        facebook=findViewById(R.id.contact_facebppkBtn);
        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Contactus.this, "gmail ho", Toast.LENGTH_SHORT).show();
            }
        });
    }


}