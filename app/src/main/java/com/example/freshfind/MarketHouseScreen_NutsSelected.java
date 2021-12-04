package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MarketHouseScreen_NutsSelected extends AppCompatActivity {

    Button homeBtn3, fruitBtn3, vegBtn3, nutButt3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_house_screen_nuts_selected);
        homeBtn3 = findViewById(R.id.homeButton4);
        fruitBtn3 = findViewById(R.id.fruitButton4);
        vegBtn3 = findViewById(R.id.vegetableButton4);
        nutButt3 = findViewById(R.id.nutsButton4);

        homeBtn3.setOnClickListener((view)->
        {
            goHome();
        });

        fruitBtn3.setOnClickListener((view)->
        {
            goToFruitsSection();
        });

        vegBtn3.setOnClickListener((view)->
        {
            goToVegsSection();
        });

        nutButt3.setOnClickListener((view)->
        {
            goToNutsSection();
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

    public void goToVegsSection()
    {
        Intent intent = new Intent(this, MarketHouseScreen_VegsSelected.class);
        startActivity(intent);
    }

    public void goToNutsSection()
    {
        Intent intent = new Intent(this, MarketHouseScreen_NutsSelected.class);
        startActivity(intent);
    }
}