package com.example.myform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Details extends AppCompatActivity {

    EditText nameEditText, phoneEditText, emailEditText, branchEditText, regEditText;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        nameEditText = findViewById(R.id.nameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        emailEditText = findViewById(R.id.emailEditText);
        branchEditText = findViewById(R.id.branchEditText);
        regEditText = findViewById(R.id.regEditText);

        addBtn = findViewById(R.id.addBtn);

        String name = nameEditText.getText().toString();
        String phone = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String branch = branchEditText.getText().toString();
        String reg = regEditText.getText().toString();



    addBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Details.this, ViewDetails.class);
            intent.putExtra("userName", name);
            intent.putExtra("userPhone", phone);
            intent.putExtra("userEmail", email);
            intent.putExtra("userBranch", branch);
            intent.putExtra("userReg", reg);
            startActivity(intent);

        }
    });

    }
}