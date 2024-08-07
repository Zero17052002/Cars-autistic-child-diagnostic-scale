package com.example.nckh1.ListTest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.nckh1.Adapter.Test;
import com.example.nckh1.Adapter.Testlevel;
import com.example.nckh1.R;

public class activity_1qhxh extends AppCompatActivity {
    private Button btn;
    private double diem = 0.0;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private RadioButton rdo_qhxh1, rdo_qhxh15, rdo_qhxh2, rdo_qhxh25, rdo_qhxh3, rdo_qhxh35, rdo_qhxh4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1qhxh);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar = findViewById(R.id.toolbar1);
        TextView toobartitle = findViewById(R.id.toolbar_title1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        toobartitle.setText("Mục 1:Quan Hệ Xã Hội");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        radioGroup = findViewById(R.id.radioGroup_qhxh);
        rdo_qhxh1 = findViewById(R.id.qhxh_radiobutton1);
        rdo_qhxh15 = findViewById(R.id.qhxh_radiobuton15);
        rdo_qhxh2 = findViewById(R.id.qhxh_radiobuton2);
        rdo_qhxh25 = findViewById(R.id.qhxh_radiobuton25);
        rdo_qhxh3 = findViewById(R.id.qhxh_radiobuton3);
        rdo_qhxh35 = findViewById(R.id.qhxh_radiobuton35);
        rdo_qhxh4 = findViewById(R.id.qhxh_radiobuton4);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdo_qhxh1.setBackgroundColor(Color.TRANSPARENT);
                rdo_qhxh15.setBackgroundColor(Color.TRANSPARENT);
                rdo_qhxh2.setBackgroundColor(Color.TRANSPARENT);
                rdo_qhxh25.setBackgroundColor(Color.TRANSPARENT);
                rdo_qhxh3.setBackgroundColor(Color.TRANSPARENT);
                rdo_qhxh35.setBackgroundColor(Color.TRANSPARENT);
                rdo_qhxh4.setBackgroundColor(Color.TRANSPARENT);
                // Thiết lập màu nền cho RadioButton đã chọn
                RadioButton checkedRadioButton = findViewById(checkedId);
                checkedRadioButton.setTextColor(getColor(R.color.lavender));

                 // Đặt lại màu văn bản cho các RadioButton khác
                for (int i = 0; i < group.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) group.getChildAt(i);
                    if (radioButton.getId() != checkedId) {
                        radioButton.setTextColor(Color.BLACK); // Đặt màu văn bản mặc định
                    }
                }

                // Cập nhật giao diện ngay lập tức
                radioGroup.invalidate(); // hoặc radioGroup.requestLayout();
                switch (checkedId) {
                    case R.id.qhxh_radiobutton1:
                        diem = 1;
                        radioButton = findViewById(R.id.qhxh_radiobutton1);
                        break;
                    case R.id.qhxh_radiobuton15:
                        diem = 1.5;
                        radioButton = findViewById(R.id.qhxh_radiobuton15);
                        break;
                    case R.id.qhxh_radiobuton2:
                        diem = 2;
                        radioButton = findViewById(R.id.qhxh_radiobuton2);
                        break;
                    case R.id.qhxh_radiobuton25:
                        diem = 2.5;
                        radioButton = findViewById(R.id.qhxh_radiobuton25);
                        break;
                    case R.id.qhxh_radiobuton3:
                        diem = 3;
                        radioButton = findViewById(R.id.qhxh_radiobuton3);
                        break;
                    case R.id.qhxh_radiobuton35:
                        diem = 3.5;
                        radioButton = findViewById(R.id.qhxh_radiobuton35);
                        break;
                    case R.id.qhxh_radiobuton4:
                        diem = 4;
                        radioButton = findViewById(R.id.qhxh_radiobuton4);
                        break;
                    default:
                        diem = 0.0; // Giá trị mặc định của diem
                        radioButton = findViewById(R.id.qhxh_radiobutton1); // Không có RadioButton được chọn
                        break;
                }
                if (radioButton != null) {
                    radioButton.setChecked(true);
                }
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("checkedRadioButtonId", checkedId);
                editor.apply();

            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        int checkedRadioButtonId = sharedPreferences.getInt("checkedRadioButtonId", -1);
        if (checkedRadioButtonId != -1) {
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            checkedRadioButton.setChecked(true);
        }

        btn = findViewById(R.id.btn_qhxh);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    // Nếu không có radio button nào được chọn
                    Toast.makeText(activity_1qhxh.this, "Vui lòng chọn một mục", Toast.LENGTH_SHORT).show();
                } else {
                    // Nếu có radio button được chọn
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedValue = selectedRadioButton.getText().toString();
                    Toast.makeText(activity_1qhxh.this, "Bạn đã chọn mục 1 : " + selectedValue, Toast.LENGTH_SHORT).show();
                    // Lưu trữ dữ liệu vào SharedPreferences

                    SharedPreferences sharedPreferences1 = getSharedPreferences("Form1", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences1.edit();
                    editor.putFloat("doubleValue1", (float) diem);
                    editor.apply();

                    Intent intent = new Intent(activity_1qhxh.this, activity_2battrc.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }


    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, Testlevel.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onPause() {
        super.onPause();
        // Trong phương thức onPause()
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("checkedRadioButtonId", radioGroup.getCheckedRadioButtonId());
        editor.apply();
    }
}