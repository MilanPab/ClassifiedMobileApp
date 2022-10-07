package com.example.classifiedappmain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RegistrationPage extends AppCompatActivity {
    TextView loginReturn;
    private FirebaseAuth mAuth;
    private EditText username,email,password;
    Button registration_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        mAuth=FirebaseAuth.getInstance();
        loginReturn=findViewById(R.id.text_login);
        username=findViewById(R.id.Registration_Username);
        email=findViewById(R.id.Registration_email);
        password=findViewById(R.id.Registration_password);
        registration_signup=findViewById(R.id.registration_signup);
        loginReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegistrationPage.this,login.class);
                startActivity(i);
            }
        });
        registration_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { {registerNewUser();}

            }
        });


    }
    private void registerNewUser(){
        String Username = username.getText().toString();
        String Eamil= email.getText().toString();
        String Password = password.getText().toString();
        if(TextUtils.isEmpty(Username)){
            Toast.makeText(this,"Username is required",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(Eamil)){
            Toast.makeText(this,"Email is required",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(Password)){
            Toast.makeText(this,"Password is required",Toast.LENGTH_SHORT).show();
        }

        else if(Password.length()<6){
            Toast.makeText(this,"Password character must be more than 6",Toast.LENGTH_SHORT).show();

        }

        mAuth.createUserWithEmailAndPassword(Eamil,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegistrationPage.this,"registration complete",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(RegistrationPage.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(RegistrationPage.this,"registration failed"+task.getException(),Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}