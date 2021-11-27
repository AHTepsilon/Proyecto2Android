package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class InstructionScreen1 extends AppCompatActivity {

    Button overlay2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction_screen1);

        overlay2 = findViewById(R.id.secondScreenInteracts);

        overlay2.setOnClickListener((view) ->
        {
            switchScreen();
        });
    }
    public void switchScreen()
    {
        Intent pass = new Intent(this, InstructionScreen2.class);
        startActivity(pass);
    }
}