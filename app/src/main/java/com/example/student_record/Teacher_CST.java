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

public class Teacher_CST extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher__cst);

        final CST_database myDb = new CST_database(this);
        final ArrayList<HashMap<String, String>> MebmerList = myDb.SelectAllData();

        // listView1
        ListView lisView1 = (ListView) findViewById(R.id.listView1);

        SimpleAdapter sAdap;
        sAdap = new SimpleAdapter(Teacher_CST.this, MebmerList, R.layout.activity_column,
                new String[]{"MemberID", "Name", "Email"}, new int[]{R.id.T_tel, R.id.T_Name, R.id.T_Email});
        lisView1.setAdapter(sAdap);


        final Button cancel = (Button) findViewById(R.id.btnCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Open Form Main
                Intent newActivity = new Intent(Teacher_CST.this,CST.class);
                startActivity(newActivity);
            }
        });
    }

}