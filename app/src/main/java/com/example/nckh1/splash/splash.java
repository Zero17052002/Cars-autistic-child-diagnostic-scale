package com.example.nckh1.splash;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.nckh1.MainActivity;
import com.example.nckh1.R;

public class splash extends AppCompatActivity {
    private Button btnsplash;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        unit();

        btnsplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(splash.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void unit(){
        btnsplash = findViewById(R.id.btn_splash);
    }

}