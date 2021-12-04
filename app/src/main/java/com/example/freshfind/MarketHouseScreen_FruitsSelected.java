package com.example.freshfind;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MarketHouseScreen_FruitsSelected extends AppCompatActivity {

    Button homeBtn, fruitBtn, vegBtn, nutButt;
    TextView foodT;

    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_house_screen_fruits_selected);

        homeBtn = findViewById(R.id.homeButton2);
        fruitBtn = findViewById(R.id.fruitButton2);
        vegBtn = findViewById(R.id.vegetableButton2);
        nutButt = findViewById(R.id.nutsButton2);

        foodT = findViewById(R.id.foodTV);

        db = FirebaseDatabase.getInstance();

        homeBtn.setOnClickListener((view) ->
        {
            goHome();
        });

        fruitBtn.setOnClickListener((view) ->
        {
            goToFruitsSection();
        });

        vegBtn.setOnClickListener((view) ->
        {
            goToVegsSection();
        });

        nutButt.setOnClickListener((view) ->
        {
            goToNutsSection();
        });

        getFruits();
        loadDatabase();
    }

    public void getFruits()
    {

    }

    private void loadDatabase()
    {
        DatabaseReference dbRef = db.getReference("foodAtHome").child("fruits");
        dbRef.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot data) {
                        foodT.setText("");
                        for(DataSnapshot child : data.getChildren())
                        {
                            FoodCards fc = child.getValue(FoodCards.class);
                            foodT.append(fc.getNAME() + "\n" + fc.getQUANTITY() + " " + fc.getWEIGHT()
                            + "\n" + fc.getBOUGHT() + " " + fc.getEXPIRES() + "\n" + "\n");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }
        );
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