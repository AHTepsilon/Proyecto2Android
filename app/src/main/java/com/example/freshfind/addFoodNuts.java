package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class addFoodNuts extends AppCompatActivity {

    Button fruitAddBtn, vegAddBtn, nutsAddBtn, goHomeBtn, sendItemBtn;

    EditText nameT, quantityT, weightT, boughtT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_nuts);

        fruitAddBtn = findViewById(R.id.fruitButtonAdd2);
        vegAddBtn = findViewById(R.id.vegButtonAdd2);
        nutsAddBtn = findViewById(R.id.nutButtonAdd2);
        goHomeBtn = findViewById(R.id.homeButtonAdd2);
        sendItemBtn = findViewById(R.id.addItemButtonAdd2);

        nameT = findViewById(R.id.nameEditText2);
        quantityT = findViewById(R.id.quantityEditText2);
        weightT = findViewById(R.id.weightEditText2);
        boughtT = findViewById(R.id.nameBoughtText2);

        goHomeBtn.setOnClickListener((view)->
        {
            goHome();
        });

        vegAddBtn.setOnClickListener((view)->
        {
            switchToVeg();
        });

        fruitAddBtn.setOnClickListener((view)->
        {
            switchToFruits();
        });
    }

    public void goHome()
    {
        Intent intent = new Intent(this, landingScreen.class);
        startActivity(intent);
    }

    public void switchToFruits()
    {
        Intent intent = new Intent(this, addFoodFruits.class);
        startActivity(intent);
    }

    public void switchToVeg()
    {
        Intent intent = new Intent(this, addFoodVegs.class);
        startActivity(intent);
    }

}