package com.example.nckh1.splash;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.nckh1.MainActivity;
import com.example.nckh1.R;

public class splash1 extends AppCompatActivity {
    private final int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash1.this, splash.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}