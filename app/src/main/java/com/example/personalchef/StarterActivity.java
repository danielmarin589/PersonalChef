package com.example.personalchef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.personalchef.view.home.HomeActivity;
import com.google.firebase.auth.FirebaseAuth;

public class StarterActivity extends AppCompatActivity {

    private Button btnLogout,btnIngred,btnRecipe;
    private ImageView imGroceryList,imCookingTimer;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);

        btnLogout = findViewById(R.id.logout);
        btnIngred = findViewById(R.id.btnIng);
        btnRecipe = findViewById(R.id.btnRecipe);
        imCookingTimer = findViewById(R.id.imCookingTimer);
        imGroceryList = findViewById(R.id.imGroceryList);

        btnIngred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToIng = new Intent(StarterActivity.this, HomeActivity.class);
                startActivity(intToIng);
            }
        });

        btnRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToRecipe = new Intent(StarterActivity.this,RecipeActivity.class);
                startActivity(intToRecipe);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(StarterActivity.this, RegisterActivity.class);
                startActivity(intToMain);
            }
        });

        imCookingTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToTimer = new Intent(StarterActivity.this, TimerActivity.class);
                startActivity(intToTimer);
            }
        });

        imGroceryList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToGL = new Intent(StarterActivity.this,GroceryActivity.class);
                startActivity(intToGL);
            }
        });
    }
}