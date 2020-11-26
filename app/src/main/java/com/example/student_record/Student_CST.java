package com.example.student_record;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Student_CST extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__cst);

        final CST_stu_database myDb = new CST_stu_database(this);
        final ArrayList<HashMap<String, String>> studentlist = myDb.SelectAllData();

        ListView lisView1 = (ListView) findViewById(R.id.listView1);

        SimpleAdapter stu;
        stu = new SimpleAdapter(Student_CST.this, studentlist, R.layout.activity_column2,
                new String[]{"MemberID", "Name", "Email"}, new int[]{R.id.stu_ID, R.id.stu_Name, R.id.stu_Email});
        lisView1.setAdapter(stu);

        final Button cancel = (Button) findViewById(R.id.btnCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Open Form Main
                Intent newActivity = new Intent(Student_CST.this, CST.class);
                startActivity(newActivity);
            }
        });
    }
}

