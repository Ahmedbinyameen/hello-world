package com.example.bluecloudmedicalclinic.WellCome_Screen;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.bluecloudmedicalclinic.Login.Login;
import com.example.bluecloudmedicalclinic.R;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import java.util.logging.LogRecord;

public class Home extends AppCompatActivity {

    Timer timer;
   private static  int SPLASH_TIME_OUT = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ProgressBar pb;
        pb = (ProgressBar) findViewById(R.id.progressbar);
        pb.setVisibility(View.VISIBLE);
        setTitle("Loading...");
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Home.this, Login.class);
                startActivity(intent);
                finish();

            }

        },SPLASH_TIME_OUT);



    }
}


