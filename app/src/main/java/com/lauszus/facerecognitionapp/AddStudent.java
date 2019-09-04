package com.lauszus.facerecognitionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity implements View.OnClickListener {

    Button addstudent, viewclass;
    EditText stdname, stdUSN;
    DatabaseHelper db=new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);


        addstudent = findViewById(R.id.addStdBtn);
        viewclass = findViewById(R.id.viewClassBtn);
        stdname = findViewById(R.id.StdName);
        stdUSN = findViewById(R.id.StdUSN);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.addStdBtn:
                String newEntry1 = stdname.getText().toString();
                String newEntry2 = stdUSN.getText().toString();
                if (stdname.length() != 0 && stdUSN.length() > 9 && stdUSN.length() < 11) {
                    AddData(newEntry1, newEntry2);
                    stdname.setText("");
                    stdUSN.setText("");
                } else {
                    Toast.makeText(AddStudent.this, "Enter Valid Name and USN!!", Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.viewClassBtn:
                Intent a = new Intent(AddStudent.this, ClassViewList.class);
                startActivity(a);
                break;
        }

    }

  public void AddData(String newEntry1,String newEntry2){
        boolean insertData = db.adddata2(newEntry1,newEntry2);

      if(insertData){
          Toast.makeText(AddStudent.this,"Hurray!!! Successfully inserted into the database",Toast.LENGTH_LONG).show();
      }else{
          Toast.makeText(AddStudent.this,"something went wrong!!!",Toast.LENGTH_LONG).show();
      }

  }
  }

