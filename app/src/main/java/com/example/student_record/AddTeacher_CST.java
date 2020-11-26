package com.example.student_record;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NativeActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTeacher_CST extends Activity  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher__cst);


        final Button save = (Button) findViewById(R.id.btnSave);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(SaveData())
                {
                    Intent newActivity = new Intent(AddTeacher_CST.this,CST.class);
                    startActivity(newActivity);
                }
            }
        });


        // btnCancel (Cancel)
        final Button cancel = (Button) findViewById(R.id.btnCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent newActivity = new Intent(AddTeacher_CST.this,CST.class);
                startActivity(newActivity);
            }
        });

    }

    public boolean SaveData()
    {
        final EditText tMemberID = (EditText) findViewById(R.id.txtMemberID);
        final EditText tName = (EditText) findViewById(R.id.txtName);
        final EditText tTel = (EditText) findViewById(R.id.txtTel);
        final CST_database myDb = new CST_database(this);

        String NAME = tName.getText().toString();
        String Email = tTel.getText().toString();
        String Phone = tMemberID.getText().toString();

        if(NAME.isEmpty())
        {
            tName.setError("Please Enter Name");
            tName.requestFocus();
            return false;
        }
        if(Email.isEmpty())
        {
            tTel.setError("Please Enter Email");
            tTel.requestFocus();
            return false;
        }
        if(Phone.isEmpty())
        {
            tMemberID.setError("Please Enter Phone");
            tMemberID.requestFocus();
            return false;
        }

        String arrData[] = myDb.SelectData(Phone);
        if(arrData != null)
        {
           tMemberID.setError("Member Already Exists!");
            tMemberID.requestFocus();
            return false;
        }

        long saveStatus = myDb.InsertData(Phone,
                NAME,Email);
        if(saveStatus <=  0)
        {
            Toast.makeText(AddTeacher_CST.this, "Error!", Toast.LENGTH_LONG).show();
            return false;
        }

        Toast.makeText(AddTeacher_CST.this,"Data Added Successfully.",
                Toast.LENGTH_SHORT).show();

        return true;
    }

}