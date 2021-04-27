package com.example.personalchef;


import com.example.personalchef.categories.BreakfastActivity;
import com.example.personalchef.categories.DinnerActivity;
import com.example.personalchef.categories.LunchActivity;
import com.example.personalchef.categories.VegetarianActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RepickActivity extends AppCompatActivity {

    private CardView cvBreakfast,cvLunch,cvDinner,cvSnacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repick);

        cvBreakfast = findViewById(R.id.cvBreakfast);
        cvLunch = findViewById(R.id.cvLunch);
        cvDinner = findViewById(R.id.cvDinner);
        cvSnacks = findViewById(R.id.cvSnacks);

        cvBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RepickActivity.this, BreakfastActivity.class));
            }
        });

        cvLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RepickActivity.this, LunchActivity.class));
            }
        });

        cvDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RepickActivity.this, DinnerActivity.class));
            }
        });

        cvSnacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RepickActivity.this, VegetarianActivity.class));
            }
        });
    }
}