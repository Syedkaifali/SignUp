package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class home_screen extends AppCompatActivity {

    private Button scan_button;
    Toolbar toolbar;

private FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        mFirebaseAuth = FirebaseAuth.getInstance();
        Button button = findViewById(R.id.logout);
        button.setOnClickListener(view -> openlogin_page());
       ImageButton buttonUp = findViewById(R.id.upload_reports);
        buttonUp.setOnClickListener(view -> openUpload());
        ImageButton buttonView = findViewById(R.id.view_history);
        buttonView.setOnClickListener(view -> openHistory());

        scan_button= (Button) findViewById(R.id.scan_button);
        scan_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openscan_page();
            }
        });

    }



    private void openHistory() {
        Intent intent = new Intent(this, show.class);
        startActivity(intent);
    }

    public void openscan_page(){
        Intent intent = new Intent(this,scan_page.class);
        startActivity(intent);
    }

    private void openUpload() {
        Intent intent = new Intent(this, upd.class);
        startActivity(intent);
    }

    private void openlogin_page() {
    mFirebaseAuth.signOut();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}