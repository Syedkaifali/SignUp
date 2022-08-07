package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class home_screen extends AppCompatActivity {

    private Button scan_button;

private FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        mFirebaseAuth = FirebaseAuth.getInstance();
        Button button = findViewById(R.id.logout);
        button.setOnClickListener(view -> openlogin_page());

        scan_button= (Button) findViewById(R.id.scan_button);
        scan_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openscan_page();
            }
        });

    }

    public void openscan_page(){
        Intent intent = new Intent(this,scan_page.class);
        startActivity(intent);
    }

    private void openlogin_page() {
    mFirebaseAuth.signOut();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}