package com.example.myform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowDetails extends AppCompatActivity {
    Button regBtn;
    TextView name, emailID, phoneNo, school, regNo;


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

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowDetails.this, Details.class);
                startActivity(intent);
                finish();
            }
        });

    }
}