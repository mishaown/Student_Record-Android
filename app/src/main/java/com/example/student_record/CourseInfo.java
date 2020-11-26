package com.example.student_record;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class CourseInfo extends AppCompatActivity {
    PDFView courseinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);

        courseinfo = (PDFView)findViewById(R.id.course_info);
        courseinfo.fromAsset("courseinfo.pdf").load();
    }
}
