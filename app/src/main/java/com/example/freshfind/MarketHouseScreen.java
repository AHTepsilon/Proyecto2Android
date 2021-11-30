package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MarketHouseScreen extends AppCompatActivity {

    Button homeBtn, fruitBtn, vegBtn, nutButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_house_screen);

        homeBtn = findViewById(R.id.homeButton);
        fruitBtn = findViewById(R.id.fruitButton);
        vegBtn = findViewById(R.id.vegetableButton);
        nutButt = findViewById(R.id.nutsButton);

        homeBtn.setOnClickListener((view)->
        {
            goHome();
        });

        fruitBtn.setOnClickListener((view)->
        {
            goToFruitsSection();
        });
    }

    public void goHome()
    {
        Intent intent = new Intent(this, landingScreen.class);
        startActivity(intent);
    }

    public void goToFruitsSection()
    {
        Intent intent = new Intent(this, MarketHouseScreen_FruitsSelected.class);
        startActivity(intent);
    }
}