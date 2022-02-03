package com.example.myform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ViewDetails extends AppCompatActivity {
    Button regBtn;
    TextView name, emailID, phoneNo, school, regNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        regBtn = findViewById(R.id.regBtn);

        name = findViewById(R.id.name);
        emailID = findViewById(R.id.emailID);
        phoneNo = findViewById(R.id.phoneNo);
        school = findViewById(R.id.school);
        regNo = findViewById(R.id.regNo);

        //getValues
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String userEmail = intent.getStringExtra("userEmail");
        String userPhone = intent.getStringExtra("userPhone");
        String userSchool = intent.getStringExtra("userBranch");
        String userReg = intent.getStringExtra("userReg");

        //setValues
        name.setText(userName);
        emailID.setText(userEmail);
        phoneNo.setText(userPhone);
        school.setText(userSchool);
        regNo.setText(userReg);

        regBtn.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(ViewDetails.this, Details.class);
                startActivity(intent);
                finish();
            }
        });
    }
}