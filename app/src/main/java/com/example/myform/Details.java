package com.example.myform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myform.model.Model;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Details extends AppCompatActivity {

    Button addBtn;
    TextInputLayout nameInputLayout, phoneInputLayout, emailInputLayout, branchInputLayout, regInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        nameInputLayout = findViewById(R.id.nameInputLayout);
        phoneInputLayout = findViewById(R.id.phoneInputLayout);
        emailInputLayout = findViewById(R.id.emailInputLayout);
        branchInputLayout = findViewById(R.id.branchInputLayout);
        regInputLayout = findViewById(R.id.regInputLayout);

        addBtn = findViewById(R.id.addBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getText
                String name = nameInputLayout.getEditText().getText().toString();
                String phone = phoneInputLayout.getEditText().getText().toString();
                String email = emailInputLayout.getEditText().getText().toString();
                String branch = branchInputLayout.getEditText().getText().toString();
                String reg = regInputLayout.getEditText().getText().toString();

                Model model = new Model(-1, name, phone, email, branch, reg);

                Intent intent = new Intent(Details.this, ShowDetails.class);
                intent.putExtra("name", name);
                intent.putExtra("phone", phone);
                intent.putExtra("email", email);
                intent.putExtra("branch", branch);
                intent.putExtra("reg",reg);
                startActivity(intent);

               // Toast.makeText(Details.this, model.toString(), Toast.LENGTH_SHORT).show();

            }
        });

   }
}