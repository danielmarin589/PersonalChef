package com.example.personalchef.categories;
import com.example.personalchef.R;
import com.example.personalchef.RepickActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class VegetarianActivity extends AppCompatActivity {

    private TextView tvVeg,tvChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetarian);

        tvVeg= findViewById(R.id.tvVeg);
        tvChange = findViewById(R.id.tvChangeTimeOfDay);

        String vegetarian = "Vegetarian? We've got you covered!";
        tvVeg.setText(vegetarian);

        tvChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VegetarianActivity.this, RepickActivity.class));
            }
        });
    }
}