package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MarketHouseScreen_VegsSelected extends AppCompatActivity {

    Button homeBtn2, fruitBtn2, vegBtn2, nutButt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_house_screen_vegs_selected);

        homeBtn2 = findViewById(R.id.homeButton3);
        fruitBtn2 = findViewById(R.id.fruitButton3);
        vegBtn2 = findViewById(R.id.vegetableButton3);
        nutButt2 = findViewById(R.id.nutsButton3);

        homeBtn2.setOnClickListener((view)->
        {
            goHome();
        });

        fruitBtn2.setOnClickListener((view)->
        {
            goToFruitsSection();
        });

        vegBtn2.setOnClickListener((view)->
        {
            goToVegsSection();
        });

        nutButt2.setOnClickListener((view)->
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