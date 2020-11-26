package com.example.student_record;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class CST extends AppCompatActivity {
    private Button Add_teacher, Teacher_info, Add_student, Student_info, SchoolView, SignOut, GoBack, Class_Routine, CourseInfo;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cst);

        Add_teacher = (Button) findViewById(R.id.add_teacher);
        Teacher_info = (Button) findViewById(R.id.teacher);
        Add_student = (Button)findViewById(R.id.add_student);
        Student_info = (Button)findViewById(R.id.student);
        SignOut = (Button)findViewById(R.id.signout);
        GoBack = (Button)findViewById(R.id.goback);
        SchoolView = (Button)findViewById(R.id.schoolview);
        Class_Routine = (Button)findViewById(R.id.class_routine_new);
        CourseInfo = (Button)findViewById(R.id.course_info);

        Add_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CST.this, AddTeacher_CST.class);
                startActivity(intent);
            }
        });
        Teacher_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CST.this, Teacher_CST.class);
                startActivity(intent);
            }
        });

        Add_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CST.this, AddStudent_CST.class);
                startActivity(intent);
            }
        });
        Student_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CST.this, Student_CST.class);
                startActivity(intent);
            }
        });
        SchoolView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CST.this, SchoolView.class);
                startActivity(intent);
            }
        });
        Class_Routine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CST.this, ClassRoutine.class);
                startActivity(intent);
            }
        });
        CourseInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CST.this, CourseInfo.class);
                startActivity(intent);
            }
        });
        SignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(CST.this, MainActivity.class));
            }
        });
        GoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CST.this, MainActivity.class));
                Toast.makeText(CST.this, "Still LOGGED In.", Toast.LENGTH_LONG).show();
            }
        });

    }
    }
