package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<<<< Temporary merge branch 1
import android.os.Bundle;

public class LoginPage extends AppCompatActivity {

=========
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class LoginPage extends AppCompatActivity {

    EditText  mAadhar, mPassword;
    Button mloginButton;
    ProgressBar progressBar;
>>>>>>>>> Temporary merge branch 2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
<<<<<<<<< Temporary merge branch 1
=========

        mAadhar = findViewById(R.id.login_id);
        mPassword = findViewById(R.id.login_password);
        progressBar = findViewById(R.id.progressBar2);
        mloginButton =findViewById(R.id.login_button);


        mloginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });









>>>>>>>>> Temporary merge branch 2
    }
}