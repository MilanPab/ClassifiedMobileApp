package com.example.classifiedappmain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    MaterialButton material_login;
    TextView textLogin;
    EditText login_password,login_username;
    TextView textSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        mAuth=FirebaseAuth.getInstance();
        material_login=findViewById(R.id.material_login);
        textLogin=findViewById(R.id.textSignUp);
        textSignup=findViewById(R.id.textSignUp);
        login_password=findViewById(R.id.login_password);
        login_username=findViewById(R.id.login_username);
        material_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {{signUpProcess();}
//                Intent i = new Intent(login.this,MainActivity.class);
//                startActivity(i);
            }
        });

        textSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login.this,RegistrationPage.class);
                startActivity(i);
            }
        });


    }
    private void signUpProcess(){
        String email = login_username.getText().toString();
        String password = login_password.getText().toString();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(),"Email filled cannot be empty",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(),"password filled cannot be empty",Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //pd.dismiss();
                if(task.isSuccessful()){

                    Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(login.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(login.this,"registration failed"+task.getException(),Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}