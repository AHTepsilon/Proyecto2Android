package com.example.freshfind;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class addFoodFruits extends AppCompatActivity {

    Button fruitAddBtn, vegAddBtn, nutsAddBtn, goHomeBtn, sendItemBtn;

    EditText nameT, quantityT, weightT, boughtT;

    private FirebaseDatabase db;

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

        db = FirebaseDatabase.getInstance();

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

        sendItemBtn.setOnClickListener((view) ->
        {
            uploadFruit();
        });
    }

    public void uploadFruit()
    {
        DatabaseReference dbRef = db.getReference("foodAtHome").child("fruits").child(nameT.getText().toString().toLowerCase(Locale.ROOT));

        String foodName = nameT.getText().toString();
        int foodAmount = Integer.parseInt(quantityT.getText().toString());
        int foodWeight = Integer.parseInt(weightT.getText().toString());
        int foodBought = Integer.parseInt(boughtT.getText().toString());
        int foodExpires = (int) (foodBought + (-5 + Math.random() * 40));

        FoodCards foodItem = new FoodCards(foodName, foodAmount, foodWeight, foodBought, foodExpires);

        dbRef.setValue(foodItem);

        goHome();
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