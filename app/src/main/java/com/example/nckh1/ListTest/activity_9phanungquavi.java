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

public class activity_9phanungquavi extends AppCompatActivity {
    private Button btn;
    private double diem9 = 0;
    private TextView tvtitle;
    private RadioButton radioButton;

    private RadioGroup radioGroup9;
    private RadioButton rdo_9puqv1,rdo_9puqv15,rdo_9puqv2,rdo_9puqv25,rdo_9puqv3,rdo_9puqv35,rdo_9puqv4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity9phanungquavi);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar = findViewById(R.id.toolbar9);
        setSupportActionBar(toolbar);
        tvtitle = findViewById(R.id.toolbar_title9);
        tvtitle.setText("Mục 9: Phản Ứng Qua Vị");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        radioGroup9 = findViewById(R.id.radioGroup_9);
        rdo_9puqv1 = findViewById(R.id.phanungquavi9_radiobutton1);
        rdo_9puqv15 = findViewById(R.id.phanungquavi9_radiobutton15);
        rdo_9puqv2 = findViewById(R.id.phanungquavi9_radiobutton2);
        rdo_9puqv25 = findViewById(R.id.phanungquavi9_radiobutton25);
        rdo_9puqv3 = findViewById(R.id.phanungquavi9_radiobutton3);
        rdo_9puqv35 = findViewById(R.id.phanungquavi9_radiobutton35);
        rdo_9puqv4 = findViewById(R.id.phanungquavi9_radiobutton4);

        radioGroup9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rdo_9puqv1.setBackgroundColor(Color.TRANSPARENT);
                rdo_9puqv15.setBackgroundColor(Color.TRANSPARENT);
                rdo_9puqv2.setBackgroundColor(Color.TRANSPARENT);
                rdo_9puqv25.setBackgroundColor(Color.TRANSPARENT);
                rdo_9puqv3.setBackgroundColor(Color.TRANSPARENT);
                rdo_9puqv35.setBackgroundColor(Color.TRANSPARENT);
                rdo_9puqv4.setBackgroundColor(Color.TRANSPARENT);
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

                radioGroup9.invalidate();

                switch (checkedId) {
                    case R.id.phanungquavi9_radiobutton1:
                        diem9 = 1;
                        radioButton = findViewById(R.id.phanungquavi9_radiobutton1);
                        break;
                    case R.id.phanungquavi9_radiobutton15:
                        diem9 = 1.5;
                        radioButton = findViewById(R.id.phanungquavi9_radiobutton15);
                        break;
                    case R.id.phanungquavi9_radiobutton2:
                        diem9 = 2;
                        radioButton = findViewById(R.id.phanungquavi9_radiobutton2);
                        break;
                    case R.id.phanungquavi9_radiobutton25:
                        radioButton = findViewById(R.id.phanungquavi9_radiobutton25);
                        diem9 = 2.5;
                        break;
                    case R.id.phanungquavi9_radiobutton3:
                        radioButton = findViewById(R.id.phanungquavi9_radiobutton3);
                        diem9 = 3;
                        break;
                    case R.id.phanungquavi9_radiobutton35:
                        radioButton = findViewById(R.id.phanungquavi9_radiobutton35);
                        diem9 = 3.5;
                        break;
                    case R.id.phanungquavi9_radiobutton4:
                        radioButton = findViewById(R.id.phanungquavi9_radiobutton4);
                        diem9 = 4;
                        break;
                    default:
                        diem9 = 0.0; // Giá trị mặc định của diem
                        radioButton = findViewById(R.id.phanungquavi9_radiobutton1); // Không có RadioButton được chọn
                        break;
                }
                if (radioButton != null) {
                    radioButton.setChecked(true);
                }
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs9", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("checkedRadioButtonId", checkedId);
                editor.apply();

            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs9", MODE_PRIVATE);
        int checkedRadioButtonId = sharedPreferences.getInt("checkedRadioButtonId", -1);
        if (checkedRadioButtonId != -1) {
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            checkedRadioButton.setChecked(true);
        }

        btn = findViewById(R.id.btn_9);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup9.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    // Nếu không có radio button nào được chọn
                    Toast.makeText(activity_9phanungquavi.this, "Vui lòng chọn một mục", Toast.LENGTH_SHORT).show();
                } else {
                    // Nếu có radio button được chọn
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedValue = selectedRadioButton.getText().toString();
                    Toast.makeText(activity_9phanungquavi.this, "Bạn đã chọn: " + selectedValue, Toast.LENGTH_SHORT).show();
                    // gửi điểm
                    SharedPreferences sharedPreferences = getSharedPreferences("Form9", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putFloat("doubleValue9", (float) diem9);
                    editor.apply();
                    Intent intent = new Intent(activity_9phanungquavi.this,activity_10sohaihoachoihop.class);
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
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs9", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("checkedRadioButtonId", radioGroup9.getCheckedRadioButtonId());
        editor.apply();
    }

}