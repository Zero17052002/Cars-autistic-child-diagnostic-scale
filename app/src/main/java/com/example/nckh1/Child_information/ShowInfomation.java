package com.example.nckh1.Child_information;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nckh1.MainActivity;
import com.example.nckh1.R;
import com.example.nckh1.SharedPreferences.DataLocalManager;

public class ShowInfomation extends AppCompatActivity {
    private TextView tvMaso, tvhvt, tvns, tvgt, tvnoio, tvnnb, tvnnm, tvcs, tvsinh, tvts;
    private TextView btnedit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_infomation);
        unit();

        Toolbar toolbar = findViewById(R.id.toolbarShowInfomation);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ms = tvMaso.getText().toString();
                AppUntil.ms=ms;
                String hvt = tvhvt.getText().toString();
                AppUntil.hovaten=hvt;
                String ns = tvns.getText().toString();
                AppUntil.ngaysinh=ns;
                String noio = tvnoio.getText().toString();
                AppUntil.noio=noio;
                String nnb = tvnnb.getText().toString();
                AppUntil.nnb=nnb;
                String nnm = tvnnm.getText().toString();
                AppUntil.nnm=nnm;

                Intent intent = new Intent(ShowInfomation.this,Infomation.class);
                startActivity(intent);
            }
        });

        getDataMs();
        getDataHovaten();
        getDatans();
        getDatagt();
        getDatanoio();
        getDatannb();
        getDatannm();
        getDatacs();
        getDatasinh();
        getDatats();
    }

    private void getDatacs() {
        String cs = DataLocalManager.getStringcs();
        tvcs.setText(cs);
    }

    private void getDatasinh() {
        String sinh = DataLocalManager.getStrings();
        tvsinh.setText(sinh);
    }


    private void getDatats() {
        String ts = DataLocalManager.getStringts();
        tvts.setText(ts);
    }

    private void getDatannm() {
        String nnm = DataLocalManager.getStringnnm();
        tvnnm.setText(nnm);
    }

    private void getDatannb() {
        String nnb = DataLocalManager.getStringnnb();
        tvnnb.setText(nnb);
    }

    private void getDatanoio() {
        String noio = DataLocalManager.getStringnoio();
        tvnoio.setText(noio);
    }

    private void getDatagt() {
        String gt = DataLocalManager.getStringgt();
        tvgt.setText(gt);
    }

    private void getDataMs() {
       String ms = DataLocalManager.getStringMs();
        tvMaso.setText(ms);
    }
    private  void getDataHovaten(){
        String hvt = DataLocalManager.getStringhvt();
        tvhvt.setText(hvt);
    }
    private  void getDatans(){
        String ns = DataLocalManager.getStringns();
        tvns.setText(ns);
    }


    @SuppressLint("WrongViewCast")
    private void unit() {
        tvMaso = findViewById(R.id.ShowInfomationMaSo);
        tvhvt = findViewById(R.id.ShowInfomationHovaten);
        tvns = findViewById(R.id.ShowInfomationNgaysinh);
        tvgt = findViewById(R.id.ShowInfomationGioiTinh);
        tvnoio = findViewById(R.id.ShowInfomationNoio);
        tvnnb = findViewById(R.id.ShowInfomationNNB);
        tvnnm = findViewById(R.id.ShowInfomationNNM);
        tvcs = findViewById(R.id.ShowInfomationCachsinh);
        tvsinh = findViewById(R.id.ShowInfomationSinh);
        tvts = findViewById(R.id.ShowInfomationThangsinh);

        btnedit = findViewById(R.id.textViewChinhsua);

    }


    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }
}