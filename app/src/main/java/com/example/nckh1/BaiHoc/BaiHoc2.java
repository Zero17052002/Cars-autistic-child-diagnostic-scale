package com.example.nckh1.BaiHoc;

import static com.example.nckh1.R.id.toolbarBaihoc1;
import static com.example.nckh1.R.id.toolbarBaihoc2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.nckh1.R;
import com.example.nckh1.Teacher.TeacherMain;

public class BaiHoc2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_hoc2);

        Toolbar toolbar = findViewById(toolbarBaihoc2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(getApplicationContext(), TeacherMain.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);    }
}
