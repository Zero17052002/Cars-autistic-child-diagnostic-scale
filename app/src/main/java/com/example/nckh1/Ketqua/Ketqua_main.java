package com.example.nckh1.Ketqua;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.nckh1.Adapter.Testlevel;
import com.example.nckh1.R;
import com.example.nckh1.ThongKe.ThongKeKetQua;

public class Ketqua_main extends AppCompatActivity {
    private TextView tv1, tvtongdiem, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10, tv11, tv12, tv13, tv14, tv15, tvnth, tvmucdo;
    private double tongdiem;
    private TextView tvngaythuchien, tvDiem, tvmucdoketqua;
    private Button btnclickluu, btnclickluu2,btnkiemtralai;
    private ListView noteListView;
    private TextView[] textViews;
    private String savedngathuchien;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ketqua);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar = findViewById(R.id.toolbar19);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Kết Quả Đánh Giá");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tv1 = findViewById(R.id.activity_tvketquamuc1);
        tv2 = findViewById(R.id.activity_tvketquamuc2);
        tv3 = findViewById(R.id.activity_tvketquamuc3);
        tv4 = findViewById(R.id.activity_tvketquamuc4);
        tv5 = findViewById(R.id.activity_tvketquamuc5);
        tv6 = findViewById(R.id.activity_tvketquamuc6);
        tv7 = findViewById(R.id.activity_tvketquamuc7);
        tv8 = findViewById(R.id.activity_tvketquamuc8);
        tv9 = findViewById(R.id.activity_tvketquamuc9);
        tv10 = findViewById(R.id.activity_tvketquamuc10);
        tv11 = findViewById(R.id.activity_tvketquamuc11);
        tv12 = findViewById(R.id.activity_tvketquamuc12);
        tv13 = findViewById(R.id.activity_tvketquamuc13);
        tv14 = findViewById(R.id.activity_tvketquamuc14);
        tv15 = findViewById(R.id.activity_tvketquamuc15);

        SharedPreferences sharedPreferences;
        double defaultValue = 0.0;

        textViews = new TextView[]{
                tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10, tv11, tv12, tv13, tv14, tv15
        };

        double diem = 0;
        for (int i = 0; i < textViews.length; i++) {
            sharedPreferences = getSharedPreferences("Form" + (i + 1), Context.MODE_PRIVATE);
            diem = (double) sharedPreferences.getFloat("doubleValue" + (i + 1), (float) defaultValue);
            textViews[i].setText(String.valueOf(diem));
            tongdiem += diem;
        }


        tvtongdiem = findViewById(R.id.tongdiem);
        SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE).edit();
        editor.putFloat("doubleValue", (float) tongdiem);
        editor.apply();

        SharedPreferences sharedPreferencesketquats = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        double savedtongdiem = (double) sharedPreferencesketquats.getFloat("doubleValue", (float) defaultValue);
        tvtongdiem.setText(String.valueOf(savedtongdiem));


        tvnth = findViewById(R.id.tvngaythuchien);
        SharedPreferences sharedPreferencesns1 = getSharedPreferences("ns", Context.MODE_PRIVATE);
        savedngathuchien = sharedPreferencesns1.getString("ns", "");
        tvnth.setText(savedngathuchien);


        mucdo();
        sendketquacuoicung();

    }


    @SuppressLint("ResourceAsColor")
    private String mucdo() {
        tvmucdo = findViewById(R.id.tvmucdo);
        String savedMucDo = "";
        if (tongdiem <= 30) {
            tvmucdo.setText("Không tự kỉ");
            String tvmucdo1 = tvmucdo.getText().toString();
            SharedPreferences sharedPreferencesmucdo1 = getSharedPreferences("mucdo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencesmucdo1.edit();
            editor.putString("mucdo", tvmucdo1);
            editor.apply();
            SharedPreferences sharedPreferencesmucdo1save = getSharedPreferences("mucdo", Context.MODE_PRIVATE);
            savedMucDo = sharedPreferencesmucdo1save.getString("mucdo", "");
            Log.d("TAG", "Saved MucDo 1: " + savedMucDo);
            tvmucdo.setText(savedMucDo);
            tvmucdo.setTextColor(getColor(R.color.SlateBlue));


        } else if (tongdiem > 30 && tongdiem < 36) {
            tvmucdo.setText("Tự kỉ ở mức độ trung bình");
            String tvmucdo2 = tvmucdo.getText().toString();
            SharedPreferences sharedPreferencesmucdo1 = getSharedPreferences("mucdo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencesmucdo1.edit();
            editor.putString("mucdo", tvmucdo2);
            editor.apply();
            SharedPreferences sharedPreferencesmucdo1save = getSharedPreferences("mucdo", Context.MODE_PRIVATE);
            savedMucDo = sharedPreferencesmucdo1save.getString("mucdo", "");
            Log.d("TAG", "Saved MucDo 2: " + savedMucDo);
            tvmucdo.setText(savedMucDo);
            tvmucdo.setTextColor(getColor(R.color.camnhat));
        } else if (tongdiem > 36 && tongdiem <= 60) {
            tvmucdo.setText("Tự kỉ nặng");
            String tvmucdo3 = tvmucdo.getText().toString();
            SharedPreferences sharedPreferencesmucdo1 = getSharedPreferences("mucdo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencesmucdo1.edit();
            editor.putString("mucdo", tvmucdo3);
            editor.apply();
            SharedPreferences sharedPreferencesmucdo1save = getSharedPreferences("mucdo", Context.MODE_PRIVATE);
            savedMucDo = sharedPreferencesmucdo1save.getString("mucdo", "");
            Log.d("TAG", "Saved MucDo 3: " + savedMucDo);
            tvmucdo.setText(savedMucDo);
            tvmucdo.setTextColor(getColor(R.color.red));
        }


        return savedMucDo;
    }

    private void sendketquacuoicung() {
        btnkiemtralai = findViewById(R.id.btnktlai);
        btnkiemtralai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Testlevel.class);
                startActivity(intent);
                finish();
            }
        });

        btnclickluu = findViewById(R.id.btnluukq);
        btnclickluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ketqua_main.this, ThongKeKetQua.class);
                SharedPreferences sharedPreferences;
                SharedPreferences.Editor editor;

                sharedPreferences = getSharedPreferences("Ketqua1", Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                for (int i = 0; i < textViews.length; i++) {
                    double diem = Double.parseDouble(textViews[i].getText().toString());
                    editor.putFloat("doubleValue" + (i + 1), (float) diem);
                } editor.apply();
                SharedPreferences sharedPreferencesns1= getSharedPreferences("ns1", MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferencesns1.edit();
                editor1.putString("ns1",savedngathuchien);
                editor1.apply();
                startActivity(intent);
            }
        });
        btnclickluu2 = findViewById(R.id.btnluukq2);
        btnclickluu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ketqua_main.this, ThongKeKetQua.class);
                SharedPreferences sharedPreferences;
                SharedPreferences.Editor editor;

                sharedPreferences = getSharedPreferences("Ketqua2", Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                for (int i = 0; i < textViews.length; i++) {
                    double diem = Double.parseDouble(textViews[i].getText().toString());
                    editor.putFloat("doubleValue" + (i + 1), (float) diem);
                }
                editor.apply();
                SharedPreferences sharedPreferencesns2 = getSharedPreferences("ns2", MODE_PRIVATE);
                SharedPreferences.Editor editor2 = sharedPreferencesns2.edit();
                editor2.putString("ns2",savedngathuchien);
                editor2.apply();
                startActivity(intent);

            }
        });

    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);

    }

}