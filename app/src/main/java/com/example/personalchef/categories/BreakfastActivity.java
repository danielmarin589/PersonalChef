package com.example.personalchef.categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.personalchef.R;
import com.example.personalchef.RecipeActivity;
import com.example.personalchef.RepickActivity;

public class BreakfastActivity extends AppCompatActivity {

    private TextView tvBreakfast,tvChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);

        tvBreakfast = findViewById(R.id.tvBreakfast);
        tvChange = findViewById(R.id.tvChangeTimeOfDay);


        String breakfast = "Rise and shine! It's time for breakfast!";
        tvBreakfast.setText(breakfast);

        tvChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BreakfastActivity.this, RepickActivity.class));
            }
        });
    }
}
