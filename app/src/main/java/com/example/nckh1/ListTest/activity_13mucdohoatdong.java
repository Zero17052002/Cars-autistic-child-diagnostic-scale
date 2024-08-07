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

public class activity_13mucdohoatdong extends AppCompatActivity {
    private Button btn;
    private double diem13 = 0;
    private TextView tvtitle;
    private RadioButton radioButton;

    private RadioGroup radioGroup13;
    private RadioButton rdo_13_1, rdo_13_15, rdo_13_2, rdo_13_25, rdo_13_3, rdo_13_35, rdo_13_4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity13mucdohoatdong);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar = findViewById(R.id.toolbar13);
        setSupportActionBar(toolbar);
        tvtitle = findViewById(R.id.toolbar_title13);
        tvtitle.setText("Mục 13: Mức Độ Hoạt Động");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        radioGroup13 = findViewById(R.id.radioGroup_13);
        rdo_13_1 = findViewById(R.id.rdo13_radiobutton1);
        rdo_13_15 = findViewById(R.id.rdo13_radiobutton15);

        rdo_13_2 = findViewById(R.id.rdo13_radiobutton2);
        rdo_13_25 = findViewById(R.id.rdo13_radiobutton25);

        rdo_13_3 = findViewById(R.id.rdo13_radiobutton3);

        rdo_13_35 = findViewById(R.id.rdo13_radiobutton35);

        rdo_13_4 = findViewById(R.id.rdo13_radiobutton4);


        radioGroup13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdo_13_1.setBackgroundColor(Color.TRANSPARENT);
                rdo_13_15.setBackgroundColor(Color.TRANSPARENT);
                rdo_13_2.setBackgroundColor(Color.TRANSPARENT);
                rdo_13_25.setBackgroundColor(Color.TRANSPARENT);
                rdo_13_3.setBackgroundColor(Color.TRANSPARENT);
                rdo_13_35.setBackgroundColor(Color.TRANSPARENT);
                rdo_13_4.setBackgroundColor(Color.TRANSPARENT);
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

                radioGroup13.invalidate();
                switch (checkedId) {
                    case R.id.rdo13_radiobutton1:
                        diem13 = 1;
                        radioButton = findViewById(R.id.rdo13_radiobutton1);
                        break;
                    case R.id.rdo13_radiobutton15:
                        diem13 = 1.5;
                        radioButton = findViewById(R.id.rdo13_radiobutton15);

                        break;
                    case R.id.rdo13_radiobutton2:
                        radioButton = findViewById(R.id.rdo13_radiobutton2);

                        diem13 = 2;
                        break;
                    case R.id.rdo13_radiobutton25:
                        radioButton = findViewById(R.id.rdo13_radiobutton25);

                        diem13 = 2.5;
                        break;
                    case R.id.rdo13_radiobutton3:
                        radioButton = findViewById(R.id.rdo13_radiobutton3);

                        diem13 = 3;
                        break;
                    case R.id.rdo13_radiobutton35:
                        diem13 = 3.5;
                        radioButton = findViewById(R.id.rdo13_radiobutton35);

                        break;
                    case R.id.rdo13_radiobutton4:
                        diem13 = 4;
                        radioButton = findViewById(R.id.rdo13_radiobutton4);

                        break;
                    default:
                        diem13 = 0.0; // Giá trị mặc định của diem
                        radioButton = findViewById(R.id.rdo13_radiobutton1); // Không có RadioButton được chọn
                        break;
                }
                if (radioButton != null) {
                    radioButton.setChecked(true);
                }
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs13", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("checkedRadioButtonId", checkedId);
                editor.apply();

            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs13", MODE_PRIVATE);
        int checkedRadioButtonId = sharedPreferences.getInt("checkedRadioButtonId", -1);
        if (checkedRadioButtonId != -1) {
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            checkedRadioButton.setChecked(true);
        }

        btn = findViewById(R.id.btn_13);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup13.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    // Nếu không có radio button nào được chọn
                    Toast.makeText(activity_13mucdohoatdong.this, "Vui lòng chọn một mục", Toast.LENGTH_SHORT).show();
                } else {
                    // Nếu có radio button được chọn
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedValue = selectedRadioButton.getText().toString();
                    Toast.makeText(activity_13mucdohoatdong.this, "Bạn đã chọn: " + selectedValue, Toast.LENGTH_SHORT).show();
                    // gửi điểm
                    SharedPreferences sharedPreferences = getSharedPreferences("Form13", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putFloat("doubleValue13", (float) diem13);
                    editor.apply();
                    Intent intent = new Intent(activity_13mucdohoatdong.this,activity_14dapungtritue.class);
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
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs13", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("checkedRadioButtonId", radioGroup13.getCheckedRadioButtonId());
        editor.apply();
    }

}