package com.example.personalchef.categories;
import com.example.personalchef.R;
import com.example.personalchef.RepickActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LunchActivity extends AppCompatActivity {

    private TextView tvLunch,tvChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);

        tvLunch = findViewById(R.id.tvLunch);
        tvChange = findViewById(R.id.tvChangeTimeOfDay);

        String lunch = "Ready to go for some lunch?";
        tvLunch.setText(lunch);

        tvChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LunchActivity.this, RepickActivity.class));
            }
        });
    }
}