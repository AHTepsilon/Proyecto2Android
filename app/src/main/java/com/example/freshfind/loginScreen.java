package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class loginScreen extends AppCompatActivity {

    EditText emailtext, passwordtext;

    Button loginBtn;

    private FirebaseDatabase db;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        db = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        emailtext = findViewById(R.id.emailTxtField);
        passwordtext = findViewById(R.id.passwordTxtField);

        loginBtn = findViewById(R.id.loginButt);


        loginBtn.setOnClickListener((view)->
        {
            login();
        });
    }

    public void login()
    {
        auth.signInWithEmailAndPassword(emailtext.getText().toString(), passwordtext.getText().toString())
        .addOnCompleteListener(
                task ->
                {
                    if(task.isSuccessful())
                    {
                        switchScreen();

                        Toast.makeText(this, "Login succesful!", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void switchScreen()
    {
        Intent intent = new Intent(this, landingScreen.class);
        startActivity(intent);
    }
}