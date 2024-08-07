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

public class activity_10sohaihoachoihop extends AppCompatActivity {
    private Button btn;
    private double diem10 = 0;
    private TextView tvtitle;
    private RadioButton radioButton;
    private RadioGroup radioGroup10;
    private RadioButton rdo_10shhh1,rdo_10shhh15,rdo_10shhh2,rdo_10shhh25,rdo_10shhh3,rdo_10shhh35,rdo_10shhh4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity10sohaihoachoihop);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar = findViewById(R.id.toolbar10);
        setSupportActionBar(toolbar);
        tvtitle = findViewById(R.id.toolbar_title10);
        tvtitle.setText("Mục 10:Sợ Hãi,Hồi Hộp");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        radioGroup10 = findViewById(R.id.radioGroup_10);
        rdo_10shhh1 = findViewById(R.id.muc10_radiobutton1);
        rdo_10shhh15 = findViewById(R.id.muc10_radiobutton15);
        rdo_10shhh2 = findViewById(R.id.muc10_radiobutton2);
        rdo_10shhh25 = findViewById(R.id.muc10_radiobutton25);
        rdo_10shhh3 = findViewById(R.id.muc10_radiobutton3);
        rdo_10shhh35 = findViewById(R.id.muc10_radiobutton35);
        rdo_10shhh4 = findViewById(R.id.muc10_radiobutton4);

        radioGroup10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rdo_10shhh1.setBackgroundColor(Color.TRANSPARENT);
                rdo_10shhh15.setBackgroundColor(Color.TRANSPARENT);
                rdo_10shhh2.setBackgroundColor(Color.TRANSPARENT);
                rdo_10shhh25.setBackgroundColor(Color.TRANSPARENT);
                rdo_10shhh3.setBackgroundColor(Color.TRANSPARENT);
                rdo_10shhh35.setBackgroundColor(Color.TRANSPARENT);
                rdo_10shhh4.setBackgroundColor(Color.TRANSPARENT);
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

                radioGroup10.invalidate();


                switch (checkedId) {
                    case R.id.muc10_radiobutton1:
                        diem10 = 1;
                        radioButton = findViewById(R.id.muc10_radiobutton1);
                        break;
                    case R.id.muc10_radiobutton15:
                        diem10 = 1.5;
                        radioButton = findViewById(R.id.muc10_radiobutton15);
                        break;
                    case R.id.muc10_radiobutton2:
                        diem10 = 2;
                        radioButton = findViewById(R.id.muc10_radiobutton2);
                        break;
                    case R.id.muc10_radiobutton25:
                        radioButton = findViewById(R.id.muc10_radiobutton25);
                        diem10 = 2.5;
                        break;
                    case R.id.muc10_radiobutton3:
                        radioButton = findViewById(R.id.muc10_radiobutton3);
                        diem10 = 3;
                        break;
                    case R.id.muc10_radiobutton35:
                        radioButton = findViewById(R.id.muc10_radiobutton35);
                        diem10 = 3.5;
                        break;
                    case R.id.muc10_radiobutton4:
                        radioButton = findViewById(R.id.muc10_radiobutton4);
                        diem10 = 4;
                        break;
                    default:
                        diem10 = 0.0; // Giá trị mặc định của diem
                        radioButton = findViewById(R.id.muc10_radiobutton1); // Không có RadioButton được chọn
                        break;
                }
                if (radioButton != null) {
                    radioButton.setChecked(true);
                }
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs10", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("checkedRadioButtonId", checkedId);
                editor.apply();

            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs10", MODE_PRIVATE);
        int checkedRadioButtonId = sharedPreferences.getInt("checkedRadioButtonId", -1);
        if (checkedRadioButtonId != -1) {
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            checkedRadioButton.setChecked(true);
        }

        btn = findViewById(R.id.btn_10);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup10.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    // Nếu không có radio button nào được chọn
                    Toast.makeText(activity_10sohaihoachoihop.this, "Vui lòng chọn một mục", Toast.LENGTH_SHORT).show();
                } else {
                    // Nếu có radio button được chọn
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedValue = selectedRadioButton.getText().toString();
                    Toast.makeText(activity_10sohaihoachoihop.this, "Bạn đã chọn: " + selectedValue, Toast.LENGTH_SHORT).show();
                    // gửi điểm
                    SharedPreferences sharedPreferences = getSharedPreferences("Form10", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putFloat("doubleValue10", (float) diem10);
                    editor.apply();

                    Intent intent = new Intent(activity_10sohaihoachoihop.this,activity_11giaotiepbangloi.class);
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
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs10", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("checkedRadioButtonId", radioGroup10.getCheckedRadioButtonId());
        editor.apply();
    }
}