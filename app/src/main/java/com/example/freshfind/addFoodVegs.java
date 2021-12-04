package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class addFoodVegs extends AppCompatActivity {

    Button fruitAddBtn, vegAddBtn, nutsAddBtn, goHomeBtn, sendItemBtn;

    EditText nameT, quantityT, weightT, boughtT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_vegs);

        fruitAddBtn = findViewById(R.id.fruitButtonAdd3);
        vegAddBtn = findViewById(R.id.vegButtonAdd3);
        nutsAddBtn = findViewById(R.id.nutButtonAdd3);
        goHomeBtn = findViewById(R.id.homeButtonAdd3);
        sendItemBtn = findViewById(R.id.addItemButtonAdd3);

        nameT = findViewById(R.id.nameEditText3);
        quantityT = findViewById(R.id.quantityEditText3);
        weightT = findViewById(R.id.weightEditText3);
        boughtT = findViewById(R.id.nameBoughtText3);

        fruitAddBtn.setOnClickListener((view)->
        {
            switchToFruits();
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

    public void switchToFruits()
    {
        Intent intent = new Intent(this, addFoodFruits.class);
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