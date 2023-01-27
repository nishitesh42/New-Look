package com.example.newlook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.window.SplashScreen;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    FirebaseAuth mAuth;
    TextView logOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        logOut = findViewById(R.id.logout);
        mAuth = FirebaseAuth.getInstance();

        //setSupportActionBar(toolbar);

        //customization of toolbar

        logOut.setOnClickListener(view ->{
                        mAuth.signOut();
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                });

    }

    @Override
            protected void onStart() {
                        super.onStart();
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user == null){
                                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        }
            }

}