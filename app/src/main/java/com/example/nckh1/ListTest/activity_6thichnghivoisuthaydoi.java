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


public class activity_6thichnghivoisuthaydoi extends AppCompatActivity {

    private Button btn;
    private double diem6 = 0;
    private TextView tvtitle;
    private RadioButton radioButton;
    private RadioGroup radioGroup6;
    private RadioButton rdo_tnvstd1, rdo_tnvstd15, rdo_tnvstd2, rdo_tnvstd25, rdo_tnvstd3, rdo_tnvstd35, rdo_tnvstd4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity6_thichnghivoisuthaydoi);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar = findViewById(R.id.toolbar6);
        setSupportActionBar(toolbar);
        tvtitle = findViewById(R.id.toolbar_title6);
        tvtitle.setText("Mục 6: Thích Nghi");

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        radioGroup6 = findViewById(R.id.radioGroup_thichnghi6);
        rdo_tnvstd1 =findViewById(R.id.thichnghivoisuthaydoi_radiobuton1);
        rdo_tnvstd15 =findViewById(R.id.thichnghivoisuthaydoi_radiobuton15);
        rdo_tnvstd2 =findViewById(R.id.thichnghivoisuthaydoi_radiobuton2);
        rdo_tnvstd25 =findViewById(R.id.thichnghivoisuthaydoi_radiobuton25);
        rdo_tnvstd3 =findViewById(R.id.thichnghivoisuthaydoi_radiobuton3);
        rdo_tnvstd35 =findViewById(R.id.thichnghivoisuthaydoi_radiobuton35);
        rdo_tnvstd4 =findViewById(R.id.thichnghivoisuthaydoi_radiobuton4);


        radioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rdo_tnvstd1.setBackgroundColor(Color.TRANSPARENT);
                rdo_tnvstd15.setBackgroundColor(Color.TRANSPARENT);
                rdo_tnvstd2.setBackgroundColor(Color.TRANSPARENT);
                rdo_tnvstd25.setBackgroundColor(Color.TRANSPARENT);
                rdo_tnvstd3.setBackgroundColor(Color.TRANSPARENT);
                rdo_tnvstd35.setBackgroundColor(Color.TRANSPARENT);
                rdo_tnvstd4.setBackgroundColor(Color.TRANSPARENT);
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

                radioGroup6.invalidate();











                switch (checkedId) {
                    case R.id.thichnghivoisuthaydoi_radiobuton1:
                        diem6 = 1;
                        radioButton = findViewById(R.id.thichnghivoisuthaydoi_radiobuton1);
                        break;
                    case R.id.thichnghivoisuthaydoi_radiobuton15:
                        diem6 = 1.5;
                        radioButton = findViewById(R.id.thichnghivoisuthaydoi_radiobuton15);
                        break;
                    case R.id.thichnghivoisuthaydoi_radiobuton2:
                        diem6 = 2;
                        radioButton = findViewById(R.id.thichnghivoisuthaydoi_radiobuton2);
                        break;
                    case R.id.thichnghivoisuthaydoi_radiobuton25:
                        diem6 = 2.5;
                        radioButton = findViewById(R.id.thichnghivoisuthaydoi_radiobuton25);
                        break;
                    case R.id.thichnghivoisuthaydoi_radiobuton3:
                        radioButton = findViewById(R.id.thichnghivoisuthaydoi_radiobuton3);
                        diem6 = 3;
                        break;
                    case R.id.thichnghivoisuthaydoi_radiobuton35:
                        diem6 = 3.5;
                        radioButton = findViewById(R.id.thichnghivoisuthaydoi_radiobuton35);
                        break;
                    case R.id.thichnghivoisuthaydoi_radiobuton4:
                        radioButton = findViewById(R.id.thichnghivoisuthaydoi_radiobuton4);
                        diem6 = 4;
                        break;
                    default:
                        diem6 = 0.0; // Giá trị mặc định của diem
                        radioButton = findViewById(R.id.thichnghivoisuthaydoi_radiobuton1); // Không có RadioButton được chọn
                        break;
                }
                if (radioButton != null) {
                    radioButton.setChecked(true);
                }
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs6", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("checkedRadioButtonId", checkedId);
                editor.apply();

            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs6", MODE_PRIVATE);
        int checkedRadioButtonId = sharedPreferences.getInt("checkedRadioButtonId", -1);
        if (checkedRadioButtonId != -1) {
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            checkedRadioButton.setChecked(true);
        }



        btn = findViewById(R.id.btn_thichnghivoisuthaydoi);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup6.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    // Nếu không có radio button nào được chọn
                    Toast.makeText(activity_6thichnghivoisuthaydoi.this, "Vui lòng chọn một mục", Toast.LENGTH_SHORT).show();
                } else {
                    // Nếu có radio button được chọn
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedValue = selectedRadioButton.getText().toString();
                    Toast.makeText(activity_6thichnghivoisuthaydoi.this, "Bạn đã chọn: " + selectedValue, Toast.LENGTH_SHORT).show();
                    // gửi điểm
                    SharedPreferences sharedPreferences = getSharedPreferences("Form6", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putFloat("doubleValue6", (float) diem6);
                    editor.apply();

                    Intent intent = new Intent(activity_6thichnghivoisuthaydoi.this,activity_7phanungthigiac.class);
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
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs6", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("checkedRadioButtonId", radioGroup6.getCheckedRadioButtonId());
        editor.apply();
    }
}
