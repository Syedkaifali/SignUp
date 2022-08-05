package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.loginn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlogin_page();
            }
        });
        Button button2 = (Button) findViewById(R.id.signupbtn);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensignin_page();
            }
        });

    }
    public void openlogin_page(){
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }
    public void opensignin_page(){
        Intent intent = new Intent(this, Signuppage.class);
        startActivity(intent);
    }

}