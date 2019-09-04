package com.lauszus.facerecognitionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StarterActivity extends AppCompatActivity implements View.OnClickListener{

    Button addStud , scan , absent,attStud;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);

        addStud = findViewById(R.id.addStdBtn);
        scan = findViewById(R.id.StartScanBtn);
        absent = findViewById(R.id.AbsentBtn);
        attStud = findViewById(R.id.attStdBtn);


        addStud.setOnClickListener(this);
        scan.setOnClickListener(this);
        absent.setOnClickListener(this);
        attStud.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.addStdBtn:
                Intent a=new Intent(StarterActivity.this,AddStudent.class);
                startActivity(a);
                break;

            case R.id.StartScanBtn:
                Intent b=new Intent(StarterActivity.this,FaceRecognitionAppActivity.class);
                startActivity(b);
                break;

            case R.id.AbsentBtn:
                break;


            case  R.id.attStdBtn:
                break;
        }
    }
}
