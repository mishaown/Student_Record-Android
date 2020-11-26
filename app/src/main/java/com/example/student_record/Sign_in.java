package com.example.student_record;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Sign_in extends AppCompatActivity {

    private EditText email, password;
    private Button login, back;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        firebaseAuth = FirebaseAuth.getInstance();
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.btnsignup);
        back = (Button)findViewById(R.id.btnCancel);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {
                    Toast.makeText(Sign_in.this, "You are logged in!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Sign_in.this, CST.class));
                } else {
                    Toast.makeText(Sign_in.this, "Please Login!", Toast.LENGTH_SHORT).show();

                }
            }
        };

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                if(Email.isEmpty())
                {
                    email.setError("Please Enter Email");
                    email.requestFocus();
                }
                else if (Password.isEmpty())
                {
                    password.setError("Please Enter Passwoed");
                    password.requestFocus();
                }
                else if(Email.isEmpty() && Password.isEmpty())

                {
                    Toast.makeText(Sign_in.this,"Enter Email and Password Please!", Toast.LENGTH_SHORT).show();
                }
                else if(!(Email.isEmpty() && Password.isEmpty()))
                {
                    firebaseAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(Sign_in.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(Sign_in.this,"Email or Password Incorrect!", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(Sign_in.this,"Welcome to the Menu", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Sign_in.this, CST.class));
                            }
                        }
                    });
                }
                progressBar.setVisibility(View.VISIBLE);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Sign_in.this, MainActivity.class));
            }
        });


    }
    @Override
    protected void onStart () {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

}
