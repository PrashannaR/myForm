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

        String uName = getIntent().getStringExtra("name");
        String uEmail = getIntent().getStringExtra("email");
        String uPhone = getIntent().getStringExtra("phone");
        String uBranch = getIntent().getStringExtra("branch");
        String uReg = getIntent().getStringExtra("reg");

        name.setText(uName);
        emailID.setText(uEmail);
        phoneNo.setText(uPhone);
        school.setText(uBranch);
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