package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class home_screen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button scan_button;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

private FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        mFirebaseAuth = FirebaseAuth.getInstance();
        Button button = findViewById(R.id.logout);
        button.setOnClickListener(view -> openlogin_page());
       ImageButton buttonUp = findViewById(R.id.upload_reports);
        buttonUp.setOnClickListener(view -> openUpload());
        ImageButton buttonView = findViewById(R.id.view_history);
        buttonView.setOnClickListener(view -> openHistory());
        ImageButton buttonB = findViewById(R.id.beds);
        buttonB.setOnClickListener((view ->openHospital()));
        scan_button= (Button) findViewById(R.id.scan_button);
        scan_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openscan_page();
            }
        });

    }

    private void openHospital() {
        Intent intent = new Intent(this, Hhomescreen.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

        if ( drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
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


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                break;

            case R.id.nav_upload:
                Intent intent = new Intent(home_screen.this, upd.class);
                startActivity(intent);
                break;

            case R.id.nav_logout:
                mFirebaseAuth.signOut();
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
        }
        return true;
    }
}