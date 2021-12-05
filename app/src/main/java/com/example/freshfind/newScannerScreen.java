package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;
import java.util.Random;

public class newScannerScreen extends AppCompatActivity {

    Button goBackToLBtn;

    Button scan;

    EditText daysSinceBought;

    Random rand = new Random();

    int randomNumType;
    int randomFood;

    String[] fruitsArr;
    String[] vegsArr;
    String[] nutsArr;

    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_scanner_screen);

        goBackToLBtn = findViewById(R.id.goBackToL);
        scan = findViewById(R.id.scanButton);
        daysSinceBought = findViewById(R.id.daysSinceBoughtScanner);

        db = FirebaseDatabase.getInstance();

        fruitsArr = new String[3];
        vegsArr = new String[3];
        nutsArr = new String[3];

        fruitsArr[0] = "Tangerine";
        fruitsArr[1] = "Plantain";
        fruitsArr[2] = "Blueberries";

        vegsArr[0] = "Carrot";
        vegsArr[1] = "Eggplant";
        vegsArr[2] = "Corn";

        nutsArr[0] = "Sesame";
        nutsArr[1] = "Hazelnut";
        nutsArr[2] = "Coconut";

        goBackToLBtn.setOnClickListener((view)->
        {
            goBackToLanding();
        });

        scan.setOnClickListener((view)->
        {
            randomNumType = (int) rand.nextInt(2);
            randomFood = (int) rand.nextInt(2);

            switch(randomNumType)
            {
                case 0:
                    switch(randomFood)
                    {
                        case 0:
                                uploadFood(0, "fruits", fruitsArr);
                            break;
                        case 1:
                                uploadFood(1, "fruits", fruitsArr);
                                break;
                        case 2:
                            uploadFood(2, "fruits", fruitsArr);
                            break;
                    }
                    break;
                case 1:
                    switch(randomFood)
                    {
                        case 0:
                            uploadFood(0, "vegetables", vegsArr);
                            break;
                        case 1:
                            uploadFood(1, "vegetables", vegsArr);
                            break;
                        case 2:
                            uploadFood(2, "vegetables", vegsArr);
                            break;
                    }
                    break;
                case 2:
                    switch(randomFood)
                    {
                        case 0:
                            uploadFood(0, "nuts", nutsArr);
                            break;
                        case 1:
                            uploadFood(1, "nuts", nutsArr);
                            break;
                        case 2:
                            uploadFood(2, "nuts", nutsArr);
                            break;
                    }
            }

            Log.d("<<", String.valueOf(randomNumType));
            Log.d("<<", String.valueOf(randomFood));

            scannedSuccesfully();
        });
    }

    private void goBackToLanding()
    {
        Intent i = new Intent(this, landingScreen.class);
        startActivity(i);
    }

    public void scannedSuccesfully()
    {
        Intent intent = new Intent(this, finishedScanning.class);
        startActivity(intent);
    }

    public void uploadFood(int rannum, String type, String[] foodArr)
    {
        DatabaseReference dbRef = db.getReference("foodAtHome").child(type).child(foodArr[rannum].toLowerCase(Locale.ROOT));

        String foodName = foodArr[rannum];
        int foodAmount = 1;
        int foodWeight = 1;
        int foodBought = Integer.parseInt(daysSinceBought.getText().toString());
        int foodExpires = (int) (foodBought + (-5 + Math.random() * 40));

        FoodCards foodItem = new FoodCards(foodName, foodAmount, foodWeight, foodBought, foodExpires);

        dbRef.setValue(foodItem);
    }
}