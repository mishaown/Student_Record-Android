package com.example.student_record;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class SchoolView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_view);

            ViewPager viewPager = findViewById(R.id.viewpager);
            ImageAdapter adapter = new ImageAdapter(this);
            viewPager.setAdapter(adapter);
        }
    }
