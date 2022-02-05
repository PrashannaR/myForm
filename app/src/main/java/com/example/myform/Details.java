package com.example.myform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myform.database.DBHelper;
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

                boolean validate = check(name, phone, email, branch, reg);

                if (validate){
                    Model model;
                    try {
                        model = new Model(-1, name, phone, email, branch, reg);
                    }catch (Exception e){
                        model = new Model(-1, "error", "error", "error", "error", "error");
                        Toast.makeText(Details.this, "An error occurred", Toast.LENGTH_SHORT).show();
                    }

                    // add data in database
                    DBHelper dbHelper = new DBHelper(Details.this);
                    dbHelper.add(model);


                    Intent intent = new Intent(Details.this, ShowDetails.class);
                    startActivity(intent);

                }
                
            }
        });

   }

   //validate inputs
    private Boolean check(String name, String phone, String email, String branch, String reg) {
        if (name.length()==0){
            nameInputLayout.requestFocus();
            nameInputLayout.setError("Enter Your Name");
            return false;
        }
        else if(phone.length()==0){
            phoneInputLayout.requestFocus();
            phoneInputLayout.setError("Enter Your Number");
            return false;
        } else if(phone.length() != 10){
            phoneInputLayout.requestFocus();
            phoneInputLayout.setError("Enter Valid Phone Number");
            return false;
        }
        else if(email.length()==0){
            emailInputLayout.requestFocus();
            emailInputLayout.setError("Enter Your Email");
            return false;
        } else if(!email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
            emailInputLayout.requestFocus();
            emailInputLayout.setError("Enter Valid Email Address");
            return false;
        }
        else if(branch.length()==0){
            branchInputLayout.requestFocus();
            branchInputLayout.setError("Enter Your Branch Name");
            return false;
        }
        else if(reg.length()==0){
            regInputLayout.requestFocus();
            regInputLayout.setError("Enter Your Registration Number");
        }
        else {
            return true;
        }

        return null;
    }

}