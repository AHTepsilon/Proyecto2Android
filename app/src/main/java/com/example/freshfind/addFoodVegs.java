package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class addFoodVegs extends AppCompatActivity {

    Button fruitAddBtn, vegAddBtn, nutsAddBtn, goHomeBtn, sendItemBtn;

    EditText nameT, quantityT, weightT, boughtT;

    FirebaseDatabase db;

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

        db = FirebaseDatabase.getInstance();

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

        sendItemBtn.setOnClickListener((view)->
        {
            uploadFruit();
        });
    }

    public void uploadFruit()
    {
        DatabaseReference dbRef = db.getReference("foodAtHome").child("vegetables").child(nameT.getText().toString().toLowerCase(Locale.ROOT));

        String foodName = nameT.getText().toString();
        int foodAmount = Integer.parseInt(quantityT.getText().toString());
        int foodWeight = Integer.parseInt(weightT.getText().toString());
        int foodBought = Integer.parseInt(boughtT.getText().toString());
        int foodExpires = (int) (foodBought + (-5 + Math.random() * 40));

        FoodCards foodItem = new FoodCards(foodName, foodAmount, foodWeight, foodBought, foodExpires);

        dbRef.setValue(foodItem);

        goHome();
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
        Intent intent = new Intent(this, finishedScanning.class);
        startActivity(intent);
    }
}