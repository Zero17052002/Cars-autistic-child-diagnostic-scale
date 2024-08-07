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

public class activity_5sudungdovat extends AppCompatActivity {
    private Button btn;
    private double diem5 = 0;
    private TextView tvtitle;
    private RadioButton radioButton;
    private RadioGroup radioGroup5;
    private RadioButton rdo_sddv1, rdo_sddv15, rdo_sddv2, rdo_sddv25, rdo_sddv3, rdo_sddv35, rdo_sddv4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity5sudungdovat);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar = findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar);
        tvtitle = findViewById(R.id.toolbar_title5);
        tvtitle.setText("Mục 5: Sử dụng đồ vật");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        radioGroup5 = findViewById(R.id.radioGroup_sudungdovat5);
        rdo_sddv1 = findViewById(R.id.sudungdovat5_radiobutton1);
        rdo_sddv15 = findViewById(R.id.sudungdovat5_radiobuton15);
        rdo_sddv2 = findViewById(R.id.sudungdovat5_radiobuton2);
        rdo_sddv25 = findViewById(R.id.sudungdovat5_radiobuton25);
        rdo_sddv3 = findViewById(R.id.sudungdovat5_radiobuton3);
        rdo_sddv35 = findViewById(R.id.sudungdovat5_radiobuton35);
        rdo_sddv4 = findViewById(R.id.sudungdovat5_radiobuton4);

        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rdo_sddv1.setBackgroundColor(Color.TRANSPARENT);
                rdo_sddv15.setBackgroundColor(Color.TRANSPARENT);
                rdo_sddv2.setBackgroundColor(Color.TRANSPARENT);
                rdo_sddv25.setBackgroundColor(Color.TRANSPARENT);
                rdo_sddv3.setBackgroundColor(Color.TRANSPARENT);
                rdo_sddv35.setBackgroundColor(Color.TRANSPARENT);
                rdo_sddv4.setBackgroundColor(Color.TRANSPARENT);
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

                radioGroup5.invalidate();


                switch (checkedId) {
                    case R.id.sudungdovat5_radiobutton1:
                        diem5 = 1;
                        radioButton= findViewById(R.id.sudungdovat5_radiobutton1);

                        break;
                    case R.id.sudungdovat5_radiobuton15:
                        diem5 = 1.5;
                        radioButton= findViewById(R.id.sudungdovat5_radiobuton15);

                        break;
                    case R.id.sudungdovat5_radiobuton2:
                        diem5 = 2;
                        radioButton= findViewById(R.id.sudungdovat5_radiobuton2);

                        break;
                    case R.id.sudungdovat5_radiobuton25:
                        diem5 = 2.5;
                        radioButton= findViewById(R.id.sudungdovat5_radiobuton25);

                        break;
                    case R.id.sudungdovat5_radiobuton3:
                        diem5 = 3;
                        radioButton= findViewById(R.id.sudungdovat5_radiobuton3);

                        break;
                    case R.id.sudungdovat5_radiobuton35:
                        diem5 = 3.5;
                        radioButton= findViewById(R.id.sudungdovat5_radiobuton35);

                        break;
                    case R.id.sudungdovat5_radiobuton4:
                        diem5 = 4;
                        radioButton= findViewById(R.id.sudungdovat5_radiobuton4);

                        break;
                    default:
                        diem5 = 0.0; // Giá trị mặc định của diem
                        radioButton = findViewById(R.id.sudungdovat5_radiobutton1); // Không có RadioButton được chọn
                        break;
                }
                if (radioButton != null) {
                    radioButton.setChecked(true);
                }
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs5", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("checkedRadioButtonId", checkedId);
                editor.apply();

            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs5", MODE_PRIVATE);
        int checkedRadioButtonId = sharedPreferences.getInt("checkedRadioButtonId", -1);
        if (checkedRadioButtonId != -1) {
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            checkedRadioButton.setChecked(true);
        }

        btn = findViewById(R.id.btn_sudungdovat5);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup5.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    // Nếu không có radio button nào được chọn
                    Toast.makeText(activity_5sudungdovat.this, "Vui lòng chọn một mục", Toast.LENGTH_SHORT).show();
                } else {
                    // Nếu có radio button được chọn
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedValue = selectedRadioButton.getText().toString();
                    Toast.makeText(activity_5sudungdovat.this, "Bạn đã chọn: " + selectedValue, Toast.LENGTH_SHORT).show();

                    // gửi điểm
                    SharedPreferences sharedPreferences = getSharedPreferences("Form5", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putFloat("doubleValue5", (float) diem5);
                    editor.apply();
                    Intent intent = new Intent(activity_5sudungdovat.this, activity_6thichnghivoisuthaydoi.class);
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
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs5", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("checkedRadioButtonId", radioGroup5.getCheckedRadioButtonId());
        editor.apply();
    }
}