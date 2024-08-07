package com.example.nckh1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nckh1.Adapter.Testlevel;
import com.example.nckh1.Child_information.ShowInfomation;
import com.example.nckh1.Ketqua.Ketqua_main;
import com.example.nckh1.SharedPreferences.Note.Note;
import com.example.nckh1.SharedPreferences.DataLocalManager;
import com.example.nckh1.Teacher.TeacherMain;
import com.example.nckh1.ThongKe.ThongKeKetQua;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout Thontin, KiemTra, KetQua, ThongKe, BaiHoc, ChuThich;
    private TextView tvht;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animation();
        unit();
        bottomNavClick();
        OnclickItem();
        getDataName();


    }

    private void getDataName() {
        tvht = findViewById(R.id.textView);
        String hvt = DataLocalManager.getStringhvt();
        tvht.setText(hvt);
        String hello = "CARS";
        tvht.setText(hello);
    }

    private void OnclickItem() {
        unit();
        Thontin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShowInfomation.class);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                startActivity(intent);
            }
        });
        KiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Testlevel.class);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                startActivity(intent);
            }
        });
        KetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Ketqua_main.class);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                startActivity(intent);
            }
        });
        ThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThongKeKetQua.class);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                startActivity(intent);
            }
        });
        ChuThich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Note.class);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                startActivity(intent);
            }
        });
        BaiHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TeacherMain.class);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                startActivity(intent);
            }
        });
    }

    private void bottomNavClick() {

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_home:
                        return true;
                    case R.id.bottom_kid:
                        startActivity(new Intent(getApplicationContext(), ChildrenActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        finish();
                        return true;
                    case R.id.bottom_setting:
                        startActivity(new Intent(getApplicationContext(), SettingActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        finish();
                        return true;

                }
                return false;
            }
        });

    }

    private void unit() {
        Thontin = findViewById(R.id.homeprofile);
        KiemTra = findViewById(R.id.hometest);
        KetQua = findViewById(R.id.homeresult);
        ThongKe = findViewById(R.id.homethongke);
        BaiHoc = findViewById(R.id.hometeacher);
        ChuThich = findViewById(R.id.homenote);

    }

    private void animation() {
        ImageView imageView = findViewById(R.id.imageView2);
        ImageView imageView4 = findViewById(R.id.imageView4);
        ImageView imageView5 = findViewById(R.id.imageView5);
        ImageView imageView6 = findViewById(R.id.imageView6);
        ImageView imageViewo = findViewById(R.id.imageView);
        ImageView imageView3 = findViewById(R.id.imageView3);
        ImageView imageView12 = findViewById(R.id.imageView12);
        ImageView imageView13 = findViewById(R.id.imageView13);
        ImageView imageView11 = findViewById(R.id.imageView11);
        ImageView imageViewline = findViewById(R.id.line);
        TextView textView = findViewById(R.id.textView);
        ImageView imageView9 = findViewById(R.id.imageView9);
        ImageView imageView8 = findViewById(R.id.imageView8);


// Tạo animation từ trên xuống với chiều cao tương ứng
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_down_animation);

        animation.setStartOffset(0); // Thời gian delay mặc định (0ms)
        imageView3.setAnimation(animation);

        animation.setStartOffset(200); // Thời gian delay 200ms
        imageView4.setAnimation(animation);

        animation.setStartOffset(400); // Thời gian delay 400ms
        imageView.setAnimation(animation);

// Bắt đầu animation
        imageView.startAnimation(animation);
        imageView4.startAnimation(animation);
        imageView5.startAnimation(animation);
        imageView6.startAnimation(animation);
        imageViewo.startAnimation(animation);
        imageView12.startAnimation(animation);
        imageView3.startAnimation(animation);
        imageView13.startAnimation(animation);
        imageView11.startAnimation(animation);
        imageViewline.startAnimation(animation);
        textView.startAnimation(animation);
        imageView9.startAnimation(animation);
        imageView8.startAnimation(animation);




    }

}