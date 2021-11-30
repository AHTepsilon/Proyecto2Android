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

public class signUpScreen extends AppCompatActivity {

    EditText userNametxt, emailtxt, passtxt, cPasstxt;
    Button signUpBtn;

    private FirebaseAuth auth;
    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);

        userNametxt = findViewById(R.id.nameTextField);
        emailtxt = findViewById(R.id.emailTextField);
        passtxt = findViewById(R.id.passwordTextField);
        cPasstxt = findViewById(R.id.cPasswordTextField);

        signUpBtn = findViewById(R.id.signUpButt);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        signUpBtn.setOnClickListener((view)->
        {
            signUp();
        });
    }

    public void signUp()
    {
       auth.createUserWithEmailAndPassword(emailtxt.getText().toString(), passtxt.getText().toString())
       .addOnCompleteListener(
               task ->
               {
                   if(task.isSuccessful())
                   {
                       String id = auth.getCurrentUser().getUid();

                       User newUser = new User(
                               id,
                               emailtxt.getText().toString(),
                               passtxt.getText().toString(),
                               cPasstxt.getText().toString(),
                               userNametxt.getText().toString()

                       );


                        db.getReference().child("users").child(id).setValue(newUser).addOnCompleteListener(
                                taskdb ->
                                {
                                    if(taskdb.isSuccessful())
                                    {
                                        switchScreen();

                                        Toast.makeText(this, "Succesfully signed up!", Toast.LENGTH_LONG).show();
                                    }
                                }
                        );
                   }

                   else
                   {
                        Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
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