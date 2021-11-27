package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class InstructionScreen3 extends AppCompatActivity {

    Button overlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction_screen3);

        overlay = findViewById(R.id.fourthScreenInteracts);

        overlay.setOnClickListener((view) ->
        {
            switchScreen();
        });
    }
    public void switchScreen()
    {
        Intent pass = new Intent(this, InstructionScreen4.class);
        startActivity(pass);
    }
}