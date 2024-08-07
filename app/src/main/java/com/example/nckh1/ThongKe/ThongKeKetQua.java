package com.example.nckh1.ThongKe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.nckh1.BaiHoc.BaiHoc1;
import com.example.nckh1.BaiHoc.BaiHoc10;
import com.example.nckh1.BaiHoc.BaiHoc11;
import com.example.nckh1.BaiHoc.BaiHoc12;
import com.example.nckh1.BaiHoc.BaiHoc2;
import com.example.nckh1.BaiHoc.BaiHoc3;
import com.example.nckh1.BaiHoc.BaiHoc4;
import com.example.nckh1.BaiHoc.BaiHoc5;
import com.example.nckh1.BaiHoc.BaiHoc6;
import com.example.nckh1.BaiHoc.BaiHoc7;
import com.example.nckh1.BaiHoc.BaiHoc8;
import com.example.nckh1.BaiHoc.BaiHoc9;
import com.example.nckh1.BaiHoc.Baihoc13;
import com.example.nckh1.Ketqua.Ketqua_main;
import com.example.nckh1.MainActivity;
import com.example.nckh1.R;

import java.util.ArrayList;

public class ThongKeKetQua extends AppCompatActivity {
    private TextView tv1lan1, tv2lan1, tv3lan1, tv4lan1, tv5lan1, tv6lan1, tv7lan1, tv8lan1, tv9lan1, tv10lan1, tv11lan1, tv12lan1, tv13lan1, tv14lan1, tv15lan1;
    private TextView tv1lan2, tv2lan2, tv3lan2, tv4lan2, tv5lan2, tv6lan2, tv7lan2, tv8lan2, tv9lan2, tv10lan2, tv11lan2, tv12lan2, tv13lan2, tv14lan2, tv15lan2;
    private TextView sosanh1, sosanh2, sosanh3, sosanh4, sosanh5, sosanh6, sosanh7, sosanh8, sosanh9, sosanh10, sosanh11, sosanh12, sosanh13, sosanh14, sosanh15;
    private TextView Xoaketqua;
    private TextView TvTongdiemlan1, TvTongdiemlan2, Tvsstk;
    private TextView tvngaythuchien1, tvngaythuchien2;
    private TextView mucdocaithien1, mucdocaithien2, mucdocaithien3, mucdocaithien4, mucdocaithien5, mucdocaithien6, mucdocaithien7, mucdocaithien8, mucdocaithien9, mucdocaithien10, mucdocaithien11, mucdocaithien12, mucdocaithien13, mucdocaithien14, mucdocaithien15;

    private TextView muc1,muc2,muc3,muc4,muc5,muc6,muc7,muc8,muc9,muc10,muc11,muc12,muc13,muc14,muc15;

    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke_ket_qua);

        Toolbar toolbar = findViewById(R.id.toolbarthongke);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        unit();
        share();
        Onclickmuc1();


    }

    private void Onclickmuc1() {

        muc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BaiHoc1.class);
                startActivity(intent);
            }
        });
        muc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BaiHoc2.class);
                startActivity(intent);
            }
        });
        muc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BaiHoc3.class);
                startActivity(intent);
            }
        });
        muc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BaiHoc4.class);
                startActivity(intent);
            }
        });
        muc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BaiHoc5.class);
                startActivity(intent);
            }
        });
        muc6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BaiHoc6.class);
                startActivity(intent);
            }
        });
        muc7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BaiHoc7.class);
                startActivity(intent);
            }
        });
        muc8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BaiHoc8.class);
                startActivity(intent);
            }
        });
        muc9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BaiHoc9.class);
                startActivity(intent);
            }
        });
        muc10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BaiHoc10.class);
                startActivity(intent);
            }
        });
        muc11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BaiHoc11.class);
                startActivity(intent);
            }
        });
        muc12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BaiHoc12.class);
                startActivity(intent);
            }
        });
        muc13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Baihoc13.class);
                startActivity(intent);
            }
        });

    }

    private void unit() {
        // lần 1
        tv1lan1 = findViewById(R.id.diem1lan1);
        tv1lan2 = findViewById(R.id.diem1lan2);
        // lần 2
        tv2lan1 = findViewById(R.id.diem2lan1);
        tv2lan2 = findViewById(R.id.diem2lan2);
        // lần 3

        tv3lan1 = findViewById(R.id.diem3lan1);
        tv3lan2 = findViewById(R.id.diem3lan2);
        // lần 4
        tv4lan1 = findViewById(R.id.diem4lan1);
        tv4lan2 = findViewById(R.id.diem4lan2);
        // lần 5
        tv5lan1 = findViewById(R.id.diem5lan1);
        tv5lan2 = findViewById(R.id.diem5lan2);

        tv6lan1 = findViewById(R.id.diem6lan1);
        tv6lan2 = findViewById(R.id.diem6lan2);

        tv7lan1 = findViewById(R.id.diem7lan1);
        tv7lan2 = findViewById(R.id.diem7lan2);

        tv8lan1 = findViewById(R.id.diem8lan1);
        tv8lan2 = findViewById(R.id.diem8lan2);

        tv9lan1 = findViewById(R.id.diem9lan1);
        tv9lan2 = findViewById(R.id.diem9lan2);

        tv10lan1 = findViewById(R.id.diem10lan1);
        tv10lan2 = findViewById(R.id.diem10lan2);

        tv11lan1 = findViewById(R.id.diem11lan1);
        tv11lan2 = findViewById(R.id.diem11lan2);

        tv12lan1 = findViewById(R.id.diem12lan1);
        tv12lan2 = findViewById(R.id.diem12lan2);

        tv13lan1 = findViewById(R.id.diem13lan1);
        tv13lan2 = findViewById(R.id.diem13lan2);

        tv14lan1 = findViewById(R.id.diem14lan1);
        tv14lan2 = findViewById(R.id.diem14lan2);

        tv15lan1 = findViewById(R.id.diem15lan1);
        tv15lan2 = findViewById(R.id.diem15lan2);

        sosanh1 = findViewById(R.id.caithien1);
        sosanh2 = findViewById(R.id.caithien2);
        sosanh3 = findViewById(R.id.caithien3);
        sosanh4 = findViewById(R.id.caithien4);
        sosanh5 = findViewById(R.id.caithien5);
        sosanh6 = findViewById(R.id.caithien6);
        sosanh7 = findViewById(R.id.caithien7);
        sosanh8 = findViewById(R.id.caithien8);
        sosanh9 = findViewById(R.id.caithien9);
        sosanh10 = findViewById(R.id.caithien10);
        sosanh11 = findViewById(R.id.caithien11);
        sosanh12 = findViewById(R.id.caithien12);
        sosanh13 = findViewById(R.id.caithien13);
        sosanh14 = findViewById(R.id.caithien14);
        sosanh15 = findViewById(R.id.caithien15);

        TvTongdiemlan1 = findViewById(R.id.tongdiemlan1);
        TvTongdiemlan2 = findViewById(R.id.tongdiemlan2);
        Tvsstk = findViewById(R.id.caithiendiem);
        tvngaythuchien1 = findViewById(R.id.Ngaythuchien1);
        tvngaythuchien2 = findViewById(R.id.Ngaythuchien2);


        mucdocaithien1 = findViewById(R.id.thongke1);
        mucdocaithien2 = findViewById(R.id.thongke2);
        mucdocaithien3 = findViewById(R.id.thongke3);
        mucdocaithien4 = findViewById(R.id.thongke4);
        mucdocaithien5 = findViewById(R.id.thongke5);
        mucdocaithien6 = findViewById(R.id.thongke6);
        mucdocaithien7 = findViewById(R.id.thongke7);
        mucdocaithien8 = findViewById(R.id.thongke8);
        mucdocaithien9 = findViewById(R.id.thongke9);
        mucdocaithien10 = findViewById(R.id.thongke10);
        mucdocaithien11 = findViewById(R.id.thongke11);
        mucdocaithien12 = findViewById(R.id.thongke12);
        mucdocaithien13 = findViewById(R.id.thongke13);
        mucdocaithien14 = findViewById(R.id.thongke14);
        mucdocaithien15 = findViewById(R.id.thongke15);

        muc1= findViewById(R.id.Thongkeketqua1);
        muc2= findViewById(R.id.Thongkeketqua2);
        muc3= findViewById(R.id.Thongkeketqua3);
        muc4= findViewById(R.id.Thongkeketqua4);
        muc5= findViewById(R.id.Thongkeketqua5);
        muc6= findViewById(R.id.Thongkeketqua6);
        muc7= findViewById(R.id.Thongkeketqua7);
        muc8= findViewById(R.id.Thongkeketqua8);
        muc9= findViewById(R.id.Thongkeketqua9);
        muc10= findViewById(R.id.Thongkeketqua10);
        muc11= findViewById(R.id.Thongkeketqua11);
        muc12= findViewById(R.id.Thongkeketqua12);
        muc13= findViewById(R.id.Thongkeketqua13);
        muc14= findViewById(R.id.Thongkeketqua14);
        muc15= findViewById(R.id.Thongkeketqua15);

    }

    private void share() {
        unit();
        double defaultValue = 0.0;

        TextView[] lan1TextViews = new TextView[]{
                tv1lan1, tv2lan1, tv3lan1, tv4lan1, tv5lan1, tv6lan1, tv7lan1, tv8lan1, tv9lan1, tv10lan1,
                tv11lan1, tv12lan1, tv13lan1, tv14lan1, tv15lan1
        };

        TextView[] lan2TextViews = new TextView[]{
                tv1lan2, tv2lan2, tv3lan2, tv4lan2, tv5lan2, tv6lan2, tv7lan2, tv8lan2, tv9lan2, tv10lan2,
                tv11lan2, tv12lan2, tv13lan2, tv14lan2, tv15lan2
        };
        TextView[] Tvsosanh = new TextView[]{
                sosanh1, sosanh2, sosanh3, sosanh4, sosanh5, sosanh6, sosanh7, sosanh8, sosanh9,
                sosanh10, sosanh11, sosanh12, sosanh13, sosanh14, sosanh15

        };
        TextView[] Tvmucdocaithien = new TextView[]{
                mucdocaithien1, mucdocaithien2, mucdocaithien3, mucdocaithien4, mucdocaithien5,
                mucdocaithien6, mucdocaithien7, mucdocaithien8, mucdocaithien9, mucdocaithien10,
                mucdocaithien11, mucdocaithien12, mucdocaithien13, mucdocaithien14, mucdocaithien15

        };


        SharedPreferences sharedPreferences1, sharedPreferences2;
        SharedPreferences.Editor editor;

        String ngaythuchien1 = "";
        String ngathuchien2 = "";

        int i = 0;
        double diem1 = 0.0;
        double diem2 = 0.0;
        double tongdiemlan1 = 0.0;
        double tongdiemlan2 = 0.0;
        double sstk = 0.0;
        for (i = 0; i < lan1TextViews.length; i++) {
            for (i = 0; i < lan2TextViews.length; i++) {
                sharedPreferences1 = getSharedPreferences("Ketqua1", Context.MODE_PRIVATE);
                diem1 = (double) sharedPreferences1.getFloat("doubleValue" + (i + 1), (float) defaultValue);
                lan1TextViews[i].setText(String.valueOf(diem1));
                tongdiemlan1 += diem1;
                TvTongdiemlan1.setText(String.valueOf(tongdiemlan1));
                sharedPreferences2 = getSharedPreferences("Ketqua2", Context.MODE_PRIVATE);
                diem2 = (double) sharedPreferences2.getFloat("doubleValue" + (i + 1), (float) defaultValue);
                lan2TextViews[i].setText(String.valueOf(diem2));
                double ss = 0.0;
                tongdiemlan2 += diem2;
                TvTongdiemlan2.setText(String.valueOf(tongdiemlan2));
                ss = diem2 - diem1;
                Tvsosanh[i].setText(String.valueOf(ss));

                sstk = tongdiemlan2 - tongdiemlan1;
                Tvsstk.setText(String.valueOf(sstk));

                if (ss == 0.0) {
                    Tvmucdocaithien[i].setText("Duy Trì");
                } else if (ss < 0.0) {
                    Tvmucdocaithien[i].setText("Cải thiện tốt");
                    Tvmucdocaithien[i].setTextColor(getColor(R.color.SlateBlue));
                } else if (ss > 0.0) {
                    Tvmucdocaithien[i].setText("Không Tốt ");
                    Tvmucdocaithien[i].setTextColor(Color.RED);
                } else if (defaultValue == 0.0) {
                    Tvmucdocaithien[i].setText("null");
                }

            }
        }
        SharedPreferences sharedPreferencesns1 = getSharedPreferences("ns1", Context.MODE_PRIVATE);
        String savedngaythuchien1 = sharedPreferencesns1.getString("ns1", "");
        tvngaythuchien1.setText(savedngaythuchien1);
        SharedPreferences sharedPreferencesns2 = getSharedPreferences("ns2", Context.MODE_PRIVATE);
        String savedngaythuchien2 = sharedPreferencesns2.getString("ns2", "");
        tvngaythuchien2.setText(savedngaythuchien2);


    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            startActivity(intent);


        }
        return super.onOptionsItemSelected(item);

    }
}
