package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sugar extends AppCompatActivity {

    Button btnInsert , btnView;
    EditText date, bp, notes;
    DatabaseReference databaseUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugar);
        btnInsert = findViewById( R.id.btn_save);
        btnView = findViewById( R.id.btn_view);
        date = findViewById(R.id.date);
        bp = findViewById( R.id.sugar_level);
        notes = findViewById( R.id.notes);
        // kaif bhai ye dheek lena
        databaseUsers = FirebaseDatabase.getInstance().getReference();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertData();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(Sugar.this,SugarActivity.class));
                finish();
            }
        });

    }
    private void InsertData() {

        String userdate = date.getText().toString();
        String usersugar = bp.getText().toString();
        String usernote = notes.getText().toString();
        String id = databaseUsers.push().getKey();

        USERSUGAR user = new USERSUGAR( userdate, usersugar, usernote);
        databaseUsers.child("userS").child(id).setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if ( task.isSuccessful()){
                            Toast.makeText(Sugar.this, "user details inserted ",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}