package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class addFoodNuts extends AppCompatActivity {

    Button fruitAddBtn, vegAddBtn, nutsAddBtn, goHomeBtn, sendItemBtn;

    EditText nameT, quantityT, weightT, boughtT;

    FirebaseDatabase db;

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

        db = FirebaseDatabase.getInstance();

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

        sendItemBtn.setOnClickListener((view)->
        {
            uploadFruit();
        });
    }

    public void uploadFruit()
    {
        DatabaseReference dbRef = db.getReference("foodAtHome").child("nuts").child(nameT.getText().toString().toLowerCase(Locale.ROOT));

        String foodName = nameT.getText().toString();
        int foodAmount = Integer.parseInt(quantityT.getText().toString());
        int foodWeight = Integer.parseInt(weightT.getText().toString());
        int foodBought = Integer.parseInt(boughtT.getText().toString());
        int foodExpires = (int) (foodBought + (-5 + Math.random() * 40));

        FoodCards foodItem = new FoodCards(foodName, foodAmount, foodWeight, foodBought, foodExpires);

        dbRef.setValue(foodItem);

        goHome();
    }

    public void goHome()
    {
        Intent intent = new Intent(this, finishedScanning.class);
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