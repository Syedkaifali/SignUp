package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class Hhomescreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hhomescreen);
        ImageButton buttonA = findViewById(R.id.all);
        buttonA.setOnClickListener(view -> openAll());
    }

    private void openAll() {
        Intent intent = new Intent(this, All_Hospital_list.class);
        startActivity(intent);
    }
}