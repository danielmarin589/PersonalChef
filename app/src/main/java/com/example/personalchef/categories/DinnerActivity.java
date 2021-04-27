package com.example.personalchef.categories;
import com.example.personalchef.R;
import com.example.personalchef.RepickActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class DinnerActivity extends AppCompatActivity {

    private TextView tvDinner,tvChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);

        tvDinner = findViewById(R.id.tvDinner);
        tvChange = findViewById(R.id.tvChangeTimeOfDay);

        String dinner = "Don't forget about dinner!";
        tvDinner.setText(dinner);

        tvChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DinnerActivity.this, RepickActivity.class));
            }
        });
    }
}