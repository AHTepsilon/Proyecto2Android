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

public class MarketHouseScreen_VegsSelected extends AppCompatActivity {

    Button homeBtn2, fruitBtn2, vegBtn2, nutButt2;

    TextView foodT2;

    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_house_screen_vegs_selected);

        homeBtn2 = findViewById(R.id.homeButton3);
        fruitBtn2 = findViewById(R.id.fruitButton3);
        vegBtn2 = findViewById(R.id.vegetableButton3);
        nutButt2 = findViewById(R.id.nutsButton3);

        foodT2 = findViewById(R.id.foodTV2);

        db = FirebaseDatabase.getInstance();

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

        loadDatabase();
    }

    private void loadDatabase()
    {
        DatabaseReference dbRef = db.getReference("foodAtHome").child("vegetables");
        dbRef.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot data)
                    {
                        foodT2.setText("");

                        for(DataSnapshot child : data.getChildren())
                        {
                            FoodCards fc = child.getValue(FoodCards.class);
                            foodT2.append(fc.getNAME() + "\n" + "amount: " + fc.getQUANTITY() + "\n" + fc.getWEIGHT() + " kg"
                                    + "\n" + "days since since bought: " + fc.getBOUGHT() + "\n" + "expires in: " + fc.getEXPIRES() + " days" + "\n" + "\n");

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