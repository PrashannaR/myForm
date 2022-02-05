package com.example.myform;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myform.database.DBHelper;

public class ShowDetails extends AppCompatActivity {
    Button regBtn;
    TextView name, emailID, phoneNo, school, regNo;
    String uName, uEmail, uPhone, uSchool, uReg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        regBtn = findViewById(R.id.regBtn);

        name = findViewById(R.id.name);
        emailID = findViewById(R.id.emailID);
        phoneNo = findViewById(R.id.phoneNo);
        school = findViewById(R.id.school);
        regNo = findViewById(R.id.regNo);

        //gets data from database
        DBHelper dbHelper = new DBHelper(this);
        Cursor cursor = dbHelper.ViewData();

        if (cursor.moveToFirst()){
            do{
                uName = cursor.getString(0);
                uPhone = cursor.getString(1);
                uEmail = cursor.getString(2);
                uSchool = cursor.getString(3);
                uReg = cursor.getString(4);

            }while (cursor.moveToNext());
        }
        name.setText(uName);
        phoneNo.setText(uPhone);
        emailID.setText(uEmail);
        school.setText(uSchool);
        regNo.setText(uReg);



        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(ShowDetails.this, Details.class);
                startActivity(newIntent);
                finish();
            }
        });

    }

}