package com.example.signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    EditText  mAadhar, mPassword;
    Button mloginButton;
    ProgressBar progressBar;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        mAadhar = findViewById(R.id.login_id);
        mPassword = findViewById(R.id.login_password);
        progressBar = findViewById(R.id.progressBar2);
        mloginButton =findViewById(R.id.login_button);
        fAuth= FirebaseAuth.getInstance();


        mloginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login_id= mAadhar.getText().toString().trim();
                String password= mPassword.getText().toString().trim();

                if (TextUtils.isEmpty((login_id))){
                    mAadhar.setError("aadhar is required");
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    mPassword.setError("enter the password");
                    return;
                }

                if ( password.length()<8)
                {
                    mPassword.setError("password must be >= 8 character");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(login_id, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if ( task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),"log in successful",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),home_screen.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "error"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

            }
        });









    }
}