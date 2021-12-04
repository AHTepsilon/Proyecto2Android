package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class landingScreen extends AppCompatActivity {

    Button marketHouseBtn, scannerBtn, addItemBtn, signOutBtn;

    private FirebaseDatabase db;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_screen);

        marketHouseBtn = findViewById(R.id.marketHouseButton);
        scannerBtn = findViewById(R.id.scannerButton);
        addItemBtn = findViewById(R.id.addItemButton);
        signOutBtn = findViewById(R.id.signOutButton);

        db = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        marketHouseBtn.setOnClickListener((view)->
        {
            goToMarketHouse();
        });

        scannerBtn.setOnClickListener((view)->
        {
            goToScanner();
        });

        addItemBtn.setOnClickListener((view)->
        {
            goToAddItem();
        });

        signOutBtn.setOnClickListener((view)->
        {
            logOut();
        });
    }

    public void goToMarketHouse()
    {
        Intent intent = new Intent(this, MarketHouseScreen.class);
        startActivity(intent);
    }

    public void goToScanner()
    {
        Intent i = new Intent(this, newScannerScreen.class);
        startActivity(i);
    }

    public void goToAddItem()
    {
        Intent i = new Intent(this, newScannerScreen.class);
        startActivity(i);
    }

    public void logOut()
    {
        auth.signOut();
        Intent i = new Intent(this, sign_up_or_login_screen.class);
        startActivity(i);
    }
}