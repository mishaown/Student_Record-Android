package com.example.student_record;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ClassRoutine extends AppCompatActivity {

    PDFView routine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_routine);

        routine = (PDFView)findViewById(R.id.class_routine);
        routine.fromAsset("timeTable.pdf").load();
    }
}
