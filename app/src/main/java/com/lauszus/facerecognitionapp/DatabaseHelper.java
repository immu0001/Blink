package com.lauszus.facerecognitionapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mylist.db";
    private static final String TABLE_NAME = "tableA";
    private static final String COL1 = "ID";
    public static final String COL2 = "USN";

    private static final String create_table =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " TEXT)";



    //...............TABLE 2 ATTRIBUTES.........................//
    private static final String TABLE_NAME2 = "tableB";
    private static final String COLA = "ID";
    private static final String COLB =  "STUDENT_NAME";
    private static final String COLC = "STUDENT_USN";


    private static final String create_tableB =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME2 + " (" + COLA + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLB + " TEXT ," + COLC + " TEXT)";


    public DatabaseHelper(Context context) {


        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_table);
        db.execSQL(create_tableB);

        Log.d("database created", "onCreate: table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);

    }

    public Cursor ViewClassStudents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME2, null);
        return data;
    }

    public Cursor ViewAttendedStudent(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    public boolean adddata2(String item1, String item2){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLA,item1);
        contentValues.put(COLB,item2);
        long result=db.insert(TABLE_NAME2,null,contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public boolean adddata(String item1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item1);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
}