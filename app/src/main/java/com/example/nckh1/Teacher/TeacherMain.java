package com.example.nckh1.Teacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

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
import com.example.nckh1.R;

import java.util.ArrayList;

public class TeacherMain extends AppCompatActivity {

    ListView lv;
    ArrayList<Teacher> teacherArrayList;
    TeacherAdapter teacherAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        Toolbar toolbar = findViewById(R.id.toolbarteacher);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        lv = findViewById(R.id.listview_dataTeacher);
        teacherArrayList = new ArrayList<>();
        teacherArrayList.add(new Teacher("1.Quan hệ xã hội "));
        teacherArrayList.add(new Teacher("2.Bắt trước"));
        teacherArrayList.add(new Teacher("3.Đáp ứng tình cảm"));
        teacherArrayList.add(new Teacher("4.Các tác động cơ thể "));
        teacherArrayList.add(new Teacher("5.Sử dụng đồ vật"));
        teacherArrayList.add(new Teacher("6.Thích nghi với sự thay đổi "));
        teacherArrayList.add(new Teacher("7.Phản ứng thị giác"));
        teacherArrayList.add(new Teacher("8.Phản ứng khứu giác "));
        teacherArrayList.add(new Teacher("9.Phản ứng qua vị, Khứu giác và sử dụng"));
        teacherArrayList.add(new Teacher("10.Sợ hãi hoặc hồi hộp "));
        teacherArrayList.add(new Teacher("11.Giao tiếp bằng lời "));
        teacherArrayList.add(new Teacher("12.Giao tiếp không lời "));
        teacherArrayList.add(new Teacher("13.Mức độ hoạt động"));
        teacherArrayList.add(new Teacher("14.Đáp ứng trí tuệ"));
        teacherArrayList.add(new Teacher("15.Ấn tượng chung"));

        teacherAdapter = new TeacherAdapter(this, teacherArrayList);
        lv.setAdapter(teacherAdapter);

        lv.setOnItemClickListener((parent, view, position, id) -> {
            switch (position) {
                case 0:
                    Intent intent = new Intent(getApplicationContext(), BaiHoc1.class);
                    startActivity(intent);
                    finish();
                    break;
                case 1:
                    Intent intent1 = new Intent(getApplicationContext(), BaiHoc2.class);
                    startActivity(intent1);
                    finish();
                    break;
                case 2:
                    Intent intent2 = new Intent(getApplicationContext(), BaiHoc3.class);
                    startActivity(intent2);
                    finish();
                    break;
                case 3:
                    Intent intent3 = new Intent(getApplicationContext(), BaiHoc4.class);
                    startActivity(intent3);
                    finish();
                    break;
                case 4:
                    Intent intent4 = new Intent(getApplicationContext(), BaiHoc5.class);
                    startActivity(intent4);
                    finish();
                    break;
                case 5:
                    Intent intent5 = new Intent(getApplicationContext(), BaiHoc6.class);
                    startActivity(intent5);
                    finish();
                    break;
                case 6:
                    Intent intent6 = new Intent(getApplicationContext(), BaiHoc7.class);
                    startActivity(intent6);
                    finish();
                    break;
                case 7:
                    Intent intent7 = new Intent(getApplicationContext(), BaiHoc8.class);
                    startActivity(intent7);
                    finish();
                    break;
                case 8:
                    Intent intent8 = new Intent(getApplicationContext(), BaiHoc9.class);
                    startActivity(intent8);
                    finish();
                    break;
                case 9:
                    Intent intent9 = new Intent(getApplicationContext(), BaiHoc10.class);
                    startActivity(intent9);
                    finish();
                    break;
                case 10:
                    Intent intent10 = new Intent(getApplicationContext(), BaiHoc11.class);
                    startActivity(intent10);
                    finish();
                    break;
                case 11:
                    Intent intent11 = new Intent(getApplicationContext(), BaiHoc12.class);
                    startActivity(intent11);
                    finish();
                    break;
                case 12:
                    Intent intent12 = new Intent(getApplicationContext(), Baihoc13.class);
                    startActivity(intent12);
                    finish();
                    break;


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

