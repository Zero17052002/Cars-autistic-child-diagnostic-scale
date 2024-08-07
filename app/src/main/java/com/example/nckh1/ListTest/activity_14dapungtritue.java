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

public class activity_14dapungtritue extends AppCompatActivity {

    private Button btn;
    private double diem14 = 0;
    private TextView tvtitle;
    private RadioButton radioButton;

    private RadioGroup radioGroup14;
    private RadioButton rdo_14_1, rdo_14_15, rdo_14_2, rdo_14_25, rdo_14_3, rdo_14_35, rdo_14_4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity14dapungtritue);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar = findViewById(R.id.toolbar14);
        setSupportActionBar(toolbar);
        tvtitle = findViewById(R.id.toolbar_title14);
        tvtitle.setText("Mục 14:Đáp Ứng Trí Tuệ");
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        radioGroup14 = findViewById(R.id.radioGroup_14);
        rdo_14_1 = findViewById(R.id.rdo14_radiobutton1);
        rdo_14_15 = findViewById(R.id.rdo14_radiobuton15);

        rdo_14_2 = findViewById(R.id.rdo14_radiobuton2);
        rdo_14_25 = findViewById(R.id.rdo14_radiobuton25);

        rdo_14_3 = findViewById(R.id.rdo14_radiobuton3);

        rdo_14_35 = findViewById(R.id.rdo14_radiobuton35);

        rdo_14_4 = findViewById(R.id.rdo14_radiobuton4);


        radioGroup14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdo_14_1.setBackgroundColor(Color.TRANSPARENT);
                rdo_14_15.setBackgroundColor(Color.TRANSPARENT);
                rdo_14_2.setBackgroundColor(Color.TRANSPARENT);
                rdo_14_25.setBackgroundColor(Color.TRANSPARENT);
                rdo_14_3.setBackgroundColor(Color.TRANSPARENT);
                rdo_14_35.setBackgroundColor(Color.TRANSPARENT);
                rdo_14_4.setBackgroundColor(Color.TRANSPARENT);
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

                radioGroup14.invalidate();
                switch (checkedId) {
                    case R.id.rdo14_radiobutton1:
                        diem14 = 1;
                        radioButton = findViewById(R.id.rdo14_radiobutton1);

                        break;
                    case R.id.rdo14_radiobuton15:
                        diem14 = 1.5;
                        radioButton = findViewById(R.id.rdo14_radiobuton15);

                        break;
                    case R.id.rdo14_radiobuton2:
                        radioButton = findViewById(R.id.rdo14_radiobuton2);

                        diem14 = 2;
                        break;
                    case R.id.rdo14_radiobuton25:
                        radioButton = findViewById(R.id.rdo14_radiobuton25);

                        diem14 = 2.5;
                        break;
                    case R.id.rdo14_radiobuton3:
                        radioButton = findViewById(R.id.rdo14_radiobuton3);
                        diem14 = 3;
                        break;
                    case R.id.rdo14_radiobuton35:
                        radioButton = findViewById(R.id.rdo14_radiobuton35);

                        diem14 = 3.5;
                        break;
                    case R.id.rdo14_radiobuton4:
                        radioButton = findViewById(R.id.rdo14_radiobuton4);

                        diem14 = 4;
                        break;
                    default:
                        diem14 = 0.0; // Giá trị mặc định của diem
                        radioButton = findViewById(R.id.rdo14_radiobutton1); // Không có RadioButton được chọn
                        break;
                }
                if (radioButton != null) {
                    radioButton.setChecked(true);
                }
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs14", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("checkedRadioButtonId", checkedId);
                editor.apply();

            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs14", MODE_PRIVATE);
        int checkedRadioButtonId = sharedPreferences.getInt("checkedRadioButtonId", -1);
        if (checkedRadioButtonId != -1) {
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            checkedRadioButton.setChecked(true);
        }

        btn = findViewById(R.id.btn_14);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup14.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    // Nếu không có radio button nào được chọn
                    Toast.makeText(activity_14dapungtritue.this, "Vui lòng chọn một mục", Toast.LENGTH_SHORT).show();
                } else {
                    // Nếu có radio button được chọn
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedValue = selectedRadioButton.getText().toString();
                    Toast.makeText(activity_14dapungtritue.this, "Bạn đã chọn: " + selectedValue, Toast.LENGTH_SHORT).show();
                    // gửi điểm
                    SharedPreferences sharedPreferences = getSharedPreferences("Form14", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putFloat("doubleValue14", (float) diem14);
                    editor.apply();

                    Intent intent = new Intent(activity_14dapungtritue.this,activity_15antuongchung.class);
                    startActivity(intent);
                finish();}

            }
        });


    }
    @Override
    protected void onPause() {
        super.onPause();
        // Trong phương thức onPause()
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs14", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("checkedRadioButtonId", radioGroup14.getCheckedRadioButtonId());
        editor.apply();
    }
}