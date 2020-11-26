package com.example.student_record;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {
    private Button cancel, forget;
    private EditText Useremail;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        forget = (Button)findViewById(R.id.forgetpass);
        cancel = (Button)findViewById(R.id.btnCancel);
        Useremail = (EditText)findViewById(R.id.email);


        forget.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(!(Useremail.getText().toString().isEmpty()))
                    firebaseAuth.sendPasswordResetEmail(Useremail.getText().toString()).addOnCompleteListener(ForgetPassword.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(ForgetPassword.this, MainActivity.class));
                                Toast.makeText(ForgetPassword.this,"Email has been Sent!", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(ForgetPassword.this,"Something is Wrong!", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                    });
                }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgetPassword.this, MainActivity.class));
            }
        });
    }
}
