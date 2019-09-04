package com.lauszus.facerecognitionapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ClassViewList extends AppCompatActivity {
    DatabaseHelper db = new DatabaseHelper(this);
    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_view_list);

        listView = findViewById(R.id.LL1);
        ArrayList<String> thelist = new ArrayList<>();
        Cursor data = db.ViewClassStudents();
        if (data.getCount()==0){
            Toast.makeText(ClassViewList.this, "NO DATA FOUND!!!", Toast.LENGTH_SHORT).show();
             }
        while(data.moveToNext()){
            thelist.add(data.getString(2));
            ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,thelist);
            listView.setAdapter(listAdapter);
        }
    }
}
