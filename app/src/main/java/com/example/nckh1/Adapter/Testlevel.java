package com.example.nckh1.Adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nckh1.ListTest.activity_1qhxh;
import com.example.nckh1.R;

import java.util.ArrayList;

public class Testlevel extends AppCompatActivity {

    ListView lv;
    ArrayList<Test> arrayList;
    TestAdapter testAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testlevel);
        Toolbar toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Kiểm Tra Các Mức Độ");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        lv = findViewById(R.id.listview_data);
        arrayList = new ArrayList<>();
        arrayList.add(new Test(R.drawable.networking, " I.Quan Hệ Xã Hôi"));
        arrayList.add(new Test(R.drawable.writer, "II.Bắt Trước"));
        arrayList.add(new Test(R.drawable.ethics, "III. Đáp Ứng Tình Cảm"));
        arrayList.add(new Test(R.drawable.gathering, "IV.Các Động Tác Cơ Thể"));
        arrayList.add(new Test(R.drawable.toys, "V.Sử Dụng Đồ Vật"));
        arrayList.add(new Test(R.drawable.thichnghi, "VI. Thích Nghi Với Sự Thay Đổi"));
        arrayList.add(new Test(R.drawable.binoculars, "VII. Phản Ứng Thị Giác"));
        arrayList.add(new Test(R.drawable.nose, "VIII. Phản Ứng Khứu Giác"));
        arrayList.add(new Test(R.drawable.spice, "Phản Ứng Qua Gia Vị, Khứu Giác và Xúc Giác Và Sử Dụng"));
        arrayList.add(new Test(R.drawable.scared, "X.Sợ Hãi Hoặc Hồi Hộp"));
        arrayList.add(new Test(R.drawable.conversation, "XI.Giao Tiếp Bằng Lời"));
        arrayList.add(new Test(R.drawable.communication, "XII. Giao Tiếp Không Lời"));
        arrayList.add(new Test(R.drawable.operation, "XIII. Mức Độ Hoạt Động"));
        arrayList.add(new Test(R.drawable.wisdom, "XIV. Đáp Úng Trí Tuệ"));
        arrayList.add(new Test(R.drawable.impressions, "XV Ấn Tượng CHung"));

        testAdapter = new TestAdapter(this, arrayList);
        lv.setAdapter(testAdapter);

        lv.setOnItemClickListener((parent, view, position, id) -> {
            switch (position) {
                case 0:
                    Intent intent = new Intent(getApplicationContext(), activity_1qhxh.class);
                    startActivity(intent);
                    finish();
                    break;

                case 1 :  case 2:    case 3 :  case 4:    case 5 :  case 6:    case 7 :  case 8:    case 9 :  case 10:    case 11:  case 12:    case 13 :  case 14:
                    Toast.makeText(this, "Vui lòng chọn Mục 1 ", Toast.LENGTH_SHORT).show();
                    break;

            }
        });

    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);    }
}

