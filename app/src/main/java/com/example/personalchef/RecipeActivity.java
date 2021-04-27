package com.example.personalchef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RecipeActivity extends AppCompatActivity {

    private TextView tvTimeOfDay, tvChangeTimeOfDay;
    ListView simpleList;
    //String mTitle[] = {"Recipe 1", "Recipe 2", "Recipe 3", "Recipe 4","Recipe 5"};
    //String mDescription[] = {"Description 1","Description 2","Description 3","Description 4","Description 5"};
    //int images[] = {R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        //simpleList = findViewById(R.id.simpleListView);
       // CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), mTitle, images);
       // simpleList.setAdapter(customAdapter);


        tvTimeOfDay = findViewById(R.id.tvTimeOfDay);
        tvChangeTimeOfDay = findViewById(R.id.tvChangeTimeOfDay);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("HHmm");

        int breakfastStart = 600; //06:00 - 10:59
        int breakfastEnd = 1059;
        int lunchStart = 1101;   //11:01 - 13:59
        int lunchEnd = 1359;
        int snackStart = 1400;   //14:00 - 18:59
        int snackEnd = 1859;
        int dinnerStart = 1900;  //19:00 - 21:59
        int dinnerEnd = 2159;

        String time = format.format(calendar.getTime());
        int currentTime =Integer.parseInt(time);

        String breakfast = "Rise and shine! It's time for breakfast!";
        String lunch = "Ready to go for some lunch?";
        String dinner = "Don't forget about dinner!";
        String snack = "Looks like you could go for a snack!";
        String late = "You shouldn't be eating right now!";



        if(breakfastStart<currentTime && currentTime<breakfastEnd) {
            tvTimeOfDay.setText(breakfast);
        }
        else if (lunchStart<currentTime && currentTime<lunchEnd) {
            tvTimeOfDay.setText(lunch);
        }

        else if(snackStart<currentTime && currentTime<snackEnd) {
            tvTimeOfDay.setText(snack);
        }

        else if(dinnerStart<currentTime && currentTime<dinnerEnd) {
            tvTimeOfDay.setText(dinner);
        }

        else{
            tvTimeOfDay.setText(late);
        }

        tvChangeTimeOfDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipeActivity.this, RepickActivity.class));
            }
        });
    }


}
