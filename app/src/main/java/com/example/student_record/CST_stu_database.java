package com.example.student_record;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

public class CST_stu_database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mystudatabase";
    private static final String TABLE_MEMBER = "students";

    public CST_stu_database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_MEMBER +
                "(STUDENT_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " Name TEXT(20)," +
                " Email TEXT(30));");

        Log.d("CREATE TABLE","Create Table Successfully.");
    }

    public long InsertData(String strMemberID, String strName, String strTel) {
        try {
            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data

            SQLiteStatement insertCmd;
            String strSQL = "INSERT INTO " + TABLE_MEMBER + "(STUDENT_ID,Name,Email) VALUES (?,?,?)";


            ContentValues Val = new ContentValues();
            Val.put("STUDENT_ID", strMemberID);
            Val.put("Name", strName);
            Val.put("Email", strTel);

            long rows = db.insert(TABLE_MEMBER, null, Val);

            db.close();
            return rows;

        } catch (Exception e) {
            return -1;
        }

    }


    public String[] SelectData(String strMemberID) {
        try {
            String arrData[] = null;
            SQLiteDatabase db;
            db = this.getReadableDatabase();

            Cursor stuCursor = db.query(TABLE_MEMBER, new String[] { "*" },
                    "STUDENT_ID=?",
                    new String[] { String.valueOf(strMemberID) }, null, null, null, null);

            if(stuCursor != null)
            {
                if (stuCursor.moveToFirst()) {
                    arrData = new String[stuCursor.getColumnCount()];

                    arrData[0] = stuCursor.getString(0);
                    arrData[1] = stuCursor.getString(1);
                    arrData[2] = stuCursor.getString(2);
                }
            }
            stuCursor.close();
            db.close();
            return arrData;

        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<HashMap<String, String>> SelectAllData() {
        try {

            ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;

            SQLiteDatabase db;
            db = this.getReadableDatabase();

            String strSQL = "SELECT  * FROM " + TABLE_MEMBER;
            Cursor cursor = db.rawQuery(strSQL, null);

            if(cursor != null)
            {
                if (cursor.moveToFirst()) {
                    do {
                        map = new HashMap<String, String>();
                        map.put("STUDENT_ID", cursor.getString(0));
                        map.put("Name", cursor.getString(1));
                        map.put("Email", cursor.getString(2));
                        MyArrList.add(map);
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();
            db.close();
            return MyArrList;

        } catch (Exception e) {
            return null;
        }

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBER);
        onCreate(db);
    }

}