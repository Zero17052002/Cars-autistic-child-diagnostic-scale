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

public class activity_8phanungthinggiac extends AppCompatActivity {
    private Button btn;
    private double diem8 = 0;
    private TextView tvtitle;
    private RadioButton radioButton8;

    private RadioGroup radioGroup8;
    private RadioButton rdo_8putg, rdo_8putg15, rdo_8putg2, rdo_8putg25, rdo_8putg3, rdo_8putg35, rdo_8putg4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity8phanungthinggiac);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar = findViewById(R.id.toolbar8);
        setSupportActionBar(toolbar);
        tvtitle = findViewById(R.id.toolbar_title8);
        tvtitle.setText("Mục 8: Phản Ứng Thính Giác");
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        radioGroup8 = findViewById(R.id.radioGroup_8);
        rdo_8putg = findViewById(R.id.putg8_radiobutton1);
        rdo_8putg15 = findViewById(R.id.putg8_radiobutton15);
        rdo_8putg2 = findViewById(R.id.putg8_radiobutton2);
        rdo_8putg25 = findViewById(R.id.putg8_radiobutton25);
        rdo_8putg3 = findViewById(R.id.putg8_radiobutton3);
        rdo_8putg35 = findViewById(R.id.putg8_radiobutton35);
        rdo_8putg4 = findViewById(R.id.putg8_radiobutton4);




        radioGroup8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rdo_8putg.setBackgroundColor(Color.TRANSPARENT);
                rdo_8putg15.setBackgroundColor(Color.TRANSPARENT);
                rdo_8putg2.setBackgroundColor(Color.TRANSPARENT);
                rdo_8putg25.setBackgroundColor(Color.TRANSPARENT);
                rdo_8putg3.setBackgroundColor(Color.TRANSPARENT);
                rdo_8putg35.setBackgroundColor(Color.TRANSPARENT);
                rdo_8putg4.setBackgroundColor(Color.TRANSPARENT);
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

                radioGroup8.invalidate();

                switch (checkedId) {
                    case R.id.putg8_radiobutton1:
                        diem8 = 1;
                        radioButton8= findViewById(R.id.putg8_radiobutton1);
                        break;
                    case R.id.putg8_radiobutton15:
                        diem8 = 1.5;
                        radioButton8= findViewById(R.id.putg8_radiobutton15);
                        break;
                    case R.id.putg8_radiobutton2:
                        diem8 = 2;
                        radioButton8= findViewById(R.id.putg8_radiobutton2);
                        break;
                    case R.id.putg8_radiobutton25:
                        diem8 = 2.5;
                        radioButton8= findViewById(R.id.putg8_radiobutton25);
                        break;
                    case R.id.putg8_radiobutton3:
                        diem8 = 3;
                        radioButton8= findViewById(R.id.putg8_radiobutton3);
                        break;
                    case R.id.putg8_radiobutton35:
                        diem8 = 3.5;
                        radioButton8= findViewById(R.id.putg8_radiobutton35);
                        break;
                    case R.id.putg8_radiobutton4:
                        diem8 = 4;
                        radioButton8= findViewById(R.id.putg8_radiobutton4);
                        break;
                    default:
                        diem8 = 0.0; // Giá trị mặc định của diem
                        radioButton8 = findViewById(R.id.putg8_radiobutton1); // Không có RadioButton được chọn
                        break;
                }
                if (radioButton8 != null) {
                    radioButton8.setChecked(true);
                }
                SharedPreferences sharedPreferences = getSharedPreferences("thu8", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("checkedRadioButtonId", checkedId);
                editor.apply();

            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("thu8", MODE_PRIVATE);
        int checkedRadioButtonId = sharedPreferences.getInt("checkedRadioButtonId", -1);
        if (checkedRadioButtonId != -1) {
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            checkedRadioButton.setChecked(true);
        }

        btn = findViewById(R.id.btn_8);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup8.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    // Nếu không có radio button nào được chọn
                    Toast.makeText(activity_8phanungthinggiac.this, "Vui lòng chọn một mục", Toast.LENGTH_SHORT).show();
                } else {
                    // Nếu có radio button được chọn
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedValue = selectedRadioButton.getText().toString();
                    Toast.makeText(activity_8phanungthinggiac.this, "Bạn đã chọn: " + selectedValue, Toast.LENGTH_SHORT).show();
                    // gửi điểm
                    SharedPreferences sharedPreferences = getSharedPreferences("Form8", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putFloat("doubleValue8", (float) diem8);
                    editor.apply();


                    Intent intent = new Intent(activity_8phanungthinggiac.this,activity_9phanungquavi.class);
                    startActivity(intent);
                    finish();
                }
            }
        });


    }
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("thu8", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("checkedRadioButtonId", radioGroup8.getCheckedRadioButtonId());
        editor.apply();
    }
}