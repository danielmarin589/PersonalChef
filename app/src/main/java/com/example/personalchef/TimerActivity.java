package com.example.personalchef;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

public class TimerActivity extends AppCompatActivity {

    private Chronometer timer;
    private boolean running;
    private long pauseOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        timer = findViewById(R.id.timer);
        timer.setFormat("Time: %s");
        
    }

    public void startTimer(View v){
        if(!running){
            timer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            timer.start();
            running = true;

            Toast.makeText(this, "Timer has started!", Toast.LENGTH_SHORT).show();
        }
    }

    public void pauseTimer(View v){
        if(running){
            timer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - timer.getBase();
            running = false;
            Toast.makeText(this, "Bing! Timer has stopped!", Toast.LENGTH_SHORT).show();
        }
    }

    public void resetTimer(View v){
        timer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;

        Toast.makeText(this, "Timer reset!", Toast.LENGTH_SHORT).show();
    }
}
