package com.example.student_record;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.auth.User;

public class MainActivity extends AppCompatActivity {

    private TextView Useremail;
    private TextView password;
    public Button login;
    public Button signin;
    public Button ResetPass;
    RelativeLayout rellay1, rellay2;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        Useremail = (EditText) findViewById(R.id.btnemail);
        password = (EditText) findViewById(R.id.iPassword);
        login = (Button) findViewById(R.id.ilogin);
        signin = (Button) findViewById(R.id.signin);
        ResetPass = (Button)findViewById(R.id.forgetpass);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);

        handler.postDelayed(runnable, 1500);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sign_in.class);
                startActivity(intent);
            }
        });

        ResetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ForgetPassword.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          if(!(Useremail.getText().toString().isEmpty() && password.getText().toString().isEmpty()))
                {
                    firebaseAuth.createUserWithEmailAndPassword(Useremail.getText().toString(),password.getText().toString()).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(MainActivity.this, Sign_in.class));
                                Toast.makeText(MainActivity.this,"Account Has Been Created!", Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.VISIBLE);
                            }
                            else {
                                Toast.makeText(MainActivity.this,"Something is Wrong!", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
                else if(Useremail.getText().toString().isEmpty())
                {
                    Useremail.setError("Please Enter Email");
                    Useremail.requestFocus();
                }
                else if (password.getText().toString().isEmpty())
                {
                    password.setError("Please Enter Passwoed");
                    password.requestFocus();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Enter Email and Password Please!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
