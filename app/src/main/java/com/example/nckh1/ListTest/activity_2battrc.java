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


public class activity_2battrc extends AppCompatActivity {
    private Button btn;
    private double diembattrc = 0;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private RadioButton rdo_batrc1, rdo_batrc15, rdo_batrc2, rdo_batrc25, rdo_batrc3, rdo_batrc35, rdo_batrc4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2battrc);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar = findViewById(R.id.toolbar2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView toobartitle = findViewById(R.id.toolbar_title2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mục 2 : Bắt Trước");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        radioGroup = findViewById(R.id.radioGroup_battrc);
        rdo_batrc1 = findViewById(R.id.battrc_radiobutton1);
        rdo_batrc15 = findViewById(R.id.battrc_radiobuton15);
        rdo_batrc2 = findViewById(R.id.battrc_radiobuton2);
        rdo_batrc25 = findViewById(R.id.battrc_radiobuton25);
        rdo_batrc3 = findViewById(R.id.battrc_radiobuton3);
        rdo_batrc35 = findViewById(R.id.battrc_radiobuton35);
        rdo_batrc4 = findViewById(R.id.battrc_radiobuton4);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdo_batrc1.setBackgroundColor(Color.TRANSPARENT);
                rdo_batrc15.setBackgroundColor(Color.TRANSPARENT);
                rdo_batrc2.setBackgroundColor(Color.TRANSPARENT);
                rdo_batrc25.setBackgroundColor(Color.TRANSPARENT);
                rdo_batrc3.setBackgroundColor(Color.TRANSPARENT);
                rdo_batrc35.setBackgroundColor(Color.TRANSPARENT);
                rdo_batrc4.setBackgroundColor(Color.TRANSPARENT);
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
                    case R.id.battrc_radiobutton1:
                        diembattrc = 1;
                        radioButton = findViewById(R.id.battrc_radiobutton1);
                        break;
                    case R.id.battrc_radiobuton15:
                        diembattrc = 1.5;
                        radioButton = findViewById(R.id.battrc_radiobuton15);
                        break;
                    case R.id.battrc_radiobuton2:
                        diembattrc = 2;
                        radioButton = findViewById(R.id.battrc_radiobuton2);
                        break;
                    case R.id.battrc_radiobuton25:
                        diembattrc = 2.5;
                        radioButton = findViewById(R.id.battrc_radiobuton25);
                        break;
                    case R.id.battrc_radiobuton3:
                        diembattrc = 3;
                        radioButton = findViewById(R.id.battrc_radiobuton3);
                        break;
                    case R.id.battrc_radiobuton35:
                        diembattrc = 3.5;
                        radioButton = findViewById(R.id.battrc_radiobuton35);
                        break;
                    case R.id.battrc_radiobuton4:
                        diembattrc = 4;
                        radioButton = findViewById(R.id.battrc_radiobuton4);
                        break;
                    default:
                        diembattrc = 0.0; // Giá trị mặc định của diem
                        radioButton = findViewById(R.id.battrc_radiobutton1); // Không có RadioButton được chọn
                        break;
                }
                if (radioButton != null) {
                    radioButton.setChecked(true);
                }
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs1", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("checkedRadioButtonId", checkedId);
                editor.apply();

            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs1", MODE_PRIVATE);
        int checkedRadioButtonId = sharedPreferences.getInt("checkedRadioButtonId", -1);
        if (checkedRadioButtonId != -1) {
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            checkedRadioButton.setChecked(true);
        }

        btn = findViewById(R.id.btn_battrc);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    // Nếu không có radio button nào được chọn
                    Toast.makeText(activity_2battrc.this, "Vui lòng chọn một mục.", Toast.LENGTH_SHORT).show();
                } else {
                    // Nếu có radio button được chọn
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedValue = selectedRadioButton.getText().toString();
                    Toast.makeText(activity_2battrc.this, "Bạn đã chọn: " + selectedValue, Toast.LENGTH_SHORT).show();

                    // gửi điểm
                    SharedPreferences sharedPreferences = getSharedPreferences("Form2", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putFloat("doubleValue2", (float) diembattrc);
                    editor.apply();
                    // gửi điểm
                    Intent intent = new Intent(activity_2battrc.this, activity_3dapungtinhcam.class);
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
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs1", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("checkedRadioButtonId", radioGroup.getCheckedRadioButtonId());
        editor.apply();
    }

}