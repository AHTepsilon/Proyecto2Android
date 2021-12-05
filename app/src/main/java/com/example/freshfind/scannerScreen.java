package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class scannerScreen extends AppCompatActivity {

    Button goBackBtn;

    int randomNumType;
    int randomFood;

    String[] fruitsArr;
    String[] vegsArr;
    String[] nutsArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_screen);

        goBackBtn = findViewById(R.id.goToLanding);

        goBackBtn.setOnClickListener((view)->
        {
            goBack();
        });
    }

    public void goBack()
    {
        Intent intent = new Intent(this, finishedScanning.class);
        startActivity(intent);
    }
}