package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class InstructionScreen4 extends AppCompatActivity {

    Button goButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction_screen4);

        goButton = findViewById(R.id.initiateButton);

        goButton.setOnClickListener((view)->
        {
            switchScreen();
        });
    }

    public void switchScreen()
    {
        Intent intent = new Intent(this, sign_up_or_login_screen.class);
        startActivity(intent);
    }
}