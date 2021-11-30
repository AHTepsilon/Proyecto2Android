package com.example.freshfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class sign_up_or_login_screen extends AppCompatActivity {

    Button loginBtn, signUpBtn;
    Button googleBtn, facebookBtn, outlookBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_or_login_screen);

        loginBtn = findViewById(R.id.loginButton);
        signUpBtn = findViewById(R.id.signUpButton);
        googleBtn = findViewById(R.id.signUpWithGoogle);
        facebookBtn = findViewById(R.id.signUpWithFacebook);
        outlookBtn = findViewById(R.id.signUpWithOutlook);

        loginBtn.setOnClickListener((view)->
        {
            switchToLogin();
        });

        signUpBtn.setOnClickListener((view)->
        {
            switchToSignUp();
        });
    }

    public void switchToLogin()
    {
        Intent intent = new Intent(this, loginScreen.class);
        startActivity(intent);
    }

    public void switchToSignUp()
    {
        Intent signUpGo = new Intent(this, signUpScreen.class);
        startActivity(signUpGo);
    }
}