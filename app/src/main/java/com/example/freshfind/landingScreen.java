package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class landingScreen extends AppCompatActivity {

    Button marketHouseBtn, scannerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_screen);

        marketHouseBtn = findViewById(R.id.marketHouseButton);
        scannerBtn = findViewById(R.id.scannerButton);

        marketHouseBtn.setOnClickListener((view)->
        {
            goToMarketHouse();
        });

        scannerBtn.setOnClickListener((view)->
        {
            goToScanner();
        });
    }

    public void goToMarketHouse()
    {
        Intent intent = new Intent(this, MarketHouseScreen.class);
        startActivity(intent);
    }

    public void goToScanner()
    {

    }
}