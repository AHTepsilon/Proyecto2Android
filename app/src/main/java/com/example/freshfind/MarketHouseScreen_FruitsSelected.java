package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MarketHouseScreen_FruitsSelected extends AppCompatActivity {

    Button homeBtn, fruitBtn, vegBtn, nutButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_house_screen_fruits_selected);

        homeBtn = findViewById(R.id.homeButton2);
        fruitBtn = findViewById(R.id.fruitButton2);
        vegBtn = findViewById(R.id.vegetableButton2);
        nutButt = findViewById(R.id.nutsButton2);

        homeBtn.setOnClickListener((view)->
        {
            goHome();
        });
    }

    public void goHome()
    {
        Intent intent = new Intent(this, landingScreen.class);
        startActivity(intent);
    }
}