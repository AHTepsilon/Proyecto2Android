package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class finishedScanning extends AppCompatActivity {

    int delayTillNextScreen;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_scanning);

        delayTillNextScreen = 2000;

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                goBackToLanding();
            }
        }, delayTillNextScreen);

    }

    public void goBackToLanding()
    {
        Intent intent = new Intent(this, landingScreen.class);
        startActivity(intent);
    }
}