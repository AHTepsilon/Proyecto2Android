package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class newScannerScreen extends AppCompatActivity {

    Button goBackToLBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_scanner_screen);

        goBackToLBtn = findViewById(R.id.goBackToL);

        goBackToLBtn.setOnClickListener((view)->
        {
            goBackToLanding();
        });
    }

    private void goBackToLanding()
    {
        Intent i = new Intent(this, landingScreen.class);
        startActivity(i);
    }
}