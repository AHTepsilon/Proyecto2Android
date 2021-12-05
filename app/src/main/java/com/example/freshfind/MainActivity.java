package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                switchScreen();
            }
        }, 2000);
    }
    public void switchScreen()
    {
        Intent pass = new Intent(this, InstructionScreen1.class);
        startActivity(pass);
    }
}