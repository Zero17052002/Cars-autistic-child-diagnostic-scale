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


public class activity_12giaotiepkhongloi extends AppCompatActivity {

    private Button btn;
    private double diem12 = 0;
    private TextView tvtitle;
    private RadioButton radioButton;

    private RadioGroup radioGroup12;
    private RadioButton rdo_12_1, rdo_12_15, rdo_12_2, rdo_12_25, rdo_12_3, rdo_12_35, rdo_12_4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity12giaotiepkhongloi);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar = findViewById(R.id.toolbar12);
        setSupportActionBar(toolbar);
        tvtitle = findViewById(R.id.toolbar_title12);
        tvtitle.setText("Mục 12: Giao Tiếp Không Lời");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        radioGroup12 = findViewById(R.id.radioGroup_12);
        rdo_12_1 = findViewById(R.id.rdo12_radiobutton1);
        rdo_12_15 = findViewById(R.id.rdo12_radiobutton15);

        rdo_12_2 = findViewById(R.id.rdo12_radiobutton2);
        rdo_12_25 = findViewById(R.id.rdo12_radiobutton25);

        rdo_12_3 = findViewById(R.id.rdo12_radiobutton3);

        rdo_12_35 = findViewById(R.id.rdo12_radiobutton35);

        rdo_12_4 = findViewById(R.id.rdo12_radiobutton4);


        radioGroup12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rdo_12_1.setBackgroundColor(Color.TRANSPARENT);
                rdo_12_15.setBackgroundColor(Color.TRANSPARENT);
                rdo_12_2.setBackgroundColor(Color.TRANSPARENT);
                rdo_12_25.setBackgroundColor(Color.TRANSPARENT);
                rdo_12_3.setBackgroundColor(Color.TRANSPARENT);
                rdo_12_35.setBackgroundColor(Color.TRANSPARENT);
                rdo_12_4.setBackgroundColor(Color.TRANSPARENT);
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

                radioGroup12.invalidate();

                switch (checkedId) {
                    case R.id.rdo12_radiobutton1:
                        diem12 = 1;
                        radioButton = findViewById(R.id.rdo12_radiobutton1);
                        break;
                    case R.id.rdo12_radiobutton15:
                        diem12 = 1.5;
                        radioButton = findViewById(R.id.rdo12_radiobutton15);

                        break;
                    case R.id.rdo12_radiobutton2:
                        radioButton = findViewById(R.id.rdo12_radiobutton2);

                        diem12 = 2;
                        break;
                    case R.id.rdo12_radiobutton25:
                        radioButton = findViewById(R.id.rdo12_radiobutton25);

                        diem12 = 2.5;
                        break;
                    case R.id.rdo12_radiobutton3:
                        diem12 = 3;
                        radioButton = findViewById(R.id.rdo12_radiobutton3);

                        break;
                    case R.id.rdo12_radiobutton35:
                        radioButton = findViewById(R.id.rdo12_radiobutton35);

                        diem12 = 3.5;
                        break;
                    case R.id.rdo12_radiobutton4:
                        diem12 = 4;
                        radioButton = findViewById(R.id.rdo12_radiobutton4);

                        break;
                    default:
                        diem12 = 0.0; // Giá trị mặc định của diem
                        radioButton = findViewById(R.id.rdo12_radiobutton1); // Không có RadioButton được chọn
                        break;
                }
                if (radioButton != null) {
                    radioButton.setChecked(true);
                }
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs12", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("checkedRadioButtonId", checkedId);
                editor.apply();

            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs12", MODE_PRIVATE);
        int checkedRadioButtonId = sharedPreferences.getInt("checkedRadioButtonId", -1);
        if (checkedRadioButtonId != -1) {
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            checkedRadioButton.setChecked(true);
        }

        btn = findViewById(R.id.btn_12);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup12.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    // Nếu không có radio button nào được chọn
                    Toast.makeText(activity_12giaotiepkhongloi.this, "Vui lòng chọn một mục", Toast.LENGTH_SHORT).show();
                } else {
                    // Nếu có radio button được chọn
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedValue = selectedRadioButton.getText().toString();
                    Toast.makeText(activity_12giaotiepkhongloi.this, "Bạn đã chọn: " + selectedValue, Toast.LENGTH_SHORT).show();
                    // gửi điểm
                    SharedPreferences sharedPreferences = getSharedPreferences("Form12", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putFloat("doubleValue12", (float) diem12);
                    editor.apply();
                    Intent intent = new Intent(activity_12giaotiepkhongloi.this, activity_13mucdohoatdong.class);
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
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs12", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("checkedRadioButtonId", radioGroup12.getCheckedRadioButtonId());
        editor.apply();
    }


}