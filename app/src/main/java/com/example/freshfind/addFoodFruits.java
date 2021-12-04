package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class addFoodFruits extends AppCompatActivity {

    Button fruitAddBtn, vegAddBtn, nutsAddBtn, goHomeBtn, sendItemBtn;

    EditText nameT, quantityT, weightT, boughtT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_fruits);

        fruitAddBtn = findViewById(R.id.fruitButtonAdd);
        vegAddBtn = findViewById(R.id.vegButtonAdd);
        nutsAddBtn = findViewById(R.id.nutButtonAdd);
        goHomeBtn = findViewById(R.id.homeButtonAdd);
        sendItemBtn = findViewById(R.id.addItemButtonAdd);

        nameT = findViewById(R.id.nameEditText);
        quantityT = findViewById(R.id.quantityEditText);
        weightT = findViewById(R.id.weightEditText);
        boughtT = findViewById(R.id.nameBoughtText);

        vegAddBtn.setOnClickListener((view)->
        {
            switchToVeg();
        });

        nutsAddBtn.setOnClickListener((view)->
        {
            switchToNuts();
        });

        goHomeBtn.setOnClickListener((view)->
        {
            goHome();
        });
    }

    public void switchToVeg()
    {
        Intent intent = new Intent(this, addFoodVegs.class);
        startActivity(intent);
    }

    public void switchToNuts()
    {
        Intent intent = new Intent(this, addFoodNuts.class);
        startActivity(intent);
    }

    public void goHome()
    {
        Intent intent = new Intent(this, landingScreen.class);
        startActivity(intent);
    }
}