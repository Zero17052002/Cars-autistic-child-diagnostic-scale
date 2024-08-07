package com.example.nckh1.BaiHoc;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nckh1.R;
import com.example.nckh1.Teacher.TeacherMain;

public class BaiHoc11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_hoc11);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(getApplicationContext(), TeacherMain.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);    }
}
