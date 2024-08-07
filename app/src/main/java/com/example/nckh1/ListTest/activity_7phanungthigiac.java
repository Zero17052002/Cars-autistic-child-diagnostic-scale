package com.example.nckh1.ListTest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.nckh1.R;


public class activity_7phanungthigiac extends AppCompatActivity {
    private Button btn;
    private double diem7 = 0;
    private TextView tvtitle;
    private RadioButton radioButton;
    private RadioGroup radioGroup7;
    private RadioButton rdo_putg1,  rdo_putg15, rdo_putg2, rdo_putg25,  rdo_putg3,  rdo_putg35, rdo_putg4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity7phanungthigiac);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar = findViewById(R.id.toolbar7);
        setSupportActionBar(toolbar);
        tvtitle = findViewById(R.id.toolbar_title7);
        tvtitle.setText("Mục 7: Phản Ứng Thị Giác");
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        radioGroup7 = findViewById(R.id.radioGroup_muc7);
        rdo_putg1 =findViewById(R.id.phanungthigiac_radiobutton1);
        rdo_putg15 =findViewById(R.id.phanungthigiac_radiobutton15);
        rdo_putg2 =findViewById(R.id.phanungthigiac_radiobutton2);
        rdo_putg25 =findViewById(R.id.phanungthigiac_radiobutton25);
        rdo_putg3 =findViewById(R.id.phanungthigiac_radiobutton3);
        rdo_putg35 =findViewById(R.id.phanungthigiac_radiobutton35);
        rdo_putg4 =findViewById(R.id.phanungthigiac_radiobutton4);


        radioGroup7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rdo_putg1.setBackgroundColor(Color.TRANSPARENT);
                rdo_putg15.setBackgroundColor(Color.TRANSPARENT);
                rdo_putg2.setBackgroundColor(Color.TRANSPARENT);
                rdo_putg25.setBackgroundColor(Color.TRANSPARENT);
                rdo_putg3.setBackgroundColor(Color.TRANSPARENT);
                rdo_putg35.setBackgroundColor(Color.TRANSPARENT);
                rdo_putg4.setBackgroundColor(Color.TRANSPARENT);
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

                radioGroup7.invalidate();



                switch (checkedId) {
                    case R.id.phanungthigiac_radiobutton1:
                        radioButton = findViewById(R.id.phanungthigiac_radiobutton1);
                        diem7 = 1;
                        break;
                    case R.id.phanungthigiac_radiobutton15:
                        diem7 = 1.5;
                        radioButton = findViewById(R.id.phanungthigiac_radiobutton15);
                        break;
                    case R.id.phanungthigiac_radiobutton2:
                        diem7 = 2;
                        radioButton = findViewById(R.id.phanungthigiac_radiobutton2);
                        break;
                    case R.id.phanungthigiac_radiobutton25:
                        diem7 = 2.5;
                        radioButton = findViewById(R.id.phanungthigiac_radiobutton25);
                        break;
                    case R.id.phanungthigiac_radiobutton3:
                        diem7 = 3;
                        radioButton = findViewById(R.id.phanungthigiac_radiobutton3);
                        break;
                    case R.id.phanungthigiac_radiobutton35:
                        radioButton = findViewById(R.id.phanungthigiac_radiobutton35);
                        diem7 = 3.5;
                        break;
                    case R.id.phanungthigiac_radiobutton4:
                        radioButton = findViewById(R.id.phanungthigiac_radiobutton4);
                        diem7 = 4;
                        break;
                    default:
                        diem7 = 0.0; // Giá trị mặc định của diem
                        radioButton = findViewById(R.id.phanungthigiac_radiobutton1); // Không có RadioButton được chọn
                        break;
                }
                if (radioButton != null) {
                    radioButton.setChecked(true);
                }
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs7", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("checkedRadioButtonId", checkedId);
                editor.apply();

            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs7", MODE_PRIVATE);
        int checkedRadioButtonId = sharedPreferences.getInt("checkedRadioButtonId", -1);
        if (checkedRadioButtonId != -1) {
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            checkedRadioButton.setChecked(true);
        }

        btn = findViewById(R.id.btn_7);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup7.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    // Nếu không có radio button nào được chọn
                    Toast.makeText(activity_7phanungthigiac.this, "Vui lòng chọn một mục", Toast.LENGTH_SHORT).show();
                } else {
                    // Nếu có radio button được chọn
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedValue = selectedRadioButton.getText().toString();
                    Toast.makeText(activity_7phanungthigiac.this, "Bạn đã chọn: " + selectedValue, Toast.LENGTH_SHORT).show();
                    // gửi điểm
                    SharedPreferences sharedPreferences = getSharedPreferences("Form7", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putFloat("doubleValue7", (float) diem7);
                    editor.apply();
                    Intent intent = new Intent(activity_7phanungthigiac.this,activity_8phanungthinggiac.class);
                    startActivity(intent);
                    finish();
                }

            }
        });


    }
    @Override
    protected void onPause() {
        super.onPause();
        // Trong phương thức onPause()
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs7", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("checkedRadioButtonId", radioGroup7.getCheckedRadioButtonId());
        editor.apply();
    }

}