package com.example.freshfind;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MarketHouseScreen_NutsSelected extends AppCompatActivity {

    Button homeBtn3, fruitBtn3, vegBtn3, nutButt3;

    TextView foodT;

    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_house_screen_nuts_selected);
        homeBtn3 = findViewById(R.id.homeButton4);
        fruitBtn3 = findViewById(R.id.fruitButton4);
        vegBtn3 = findViewById(R.id.vegetableButton4);
        nutButt3 = findViewById(R.id.nutsButton4);

        foodT = findViewById(R.id.foodTV3);

        db = FirebaseDatabase.getInstance();

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

        loadDatabase();
    }

    public void loadDatabase()
    {
        DatabaseReference dbRef = db.getReference("foodAtHome").child("nuts");
        dbRef.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot data)
                    {
                        foodT.setText("");

                        for(DataSnapshot child : data.getChildren())
                        {
                            FoodCards fc = child.getValue(FoodCards.class);
                            foodT.append(fc.getNAME() + "\n" + fc.getQUANTITY() + " " + fc.getWEIGHT()
                                    + "\n" + fc.getBOUGHT() + " " + fc.getEXPIRES());

                            Log.d("<<", fc.getNAME());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error)
                    {

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