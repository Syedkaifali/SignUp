package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class home_screen extends AppCompatActivity {
private FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        mFirebaseAuth = FirebaseAuth.getInstance();
        Button button = findViewById(R.id.logout);
        button.setOnClickListener(view -> openlogin_page());

    }

    private void openlogin_page() {
    mFirebaseAuth.signOut();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}