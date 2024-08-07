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

public class activity_11giaotiepbangloi extends AppCompatActivity {
    private Button btn;
    private double diem11 = 0;
    private TextView tvtitle;
    private RadioButton radioButton;
    private RadioGroup radioGroup11;
    private RadioButton rdo_11giaotiepbangloi1,rdo_11giaotiepbangloi15,rdo_11giaotiepbangloi2,rdo_11giaotiepbangloi25,rdo_11giaotiepbangloi3,rdo_11giaotiepbangloi35,rdo_11giaotiepbangloi4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity11giaotiepbangloi);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar = findViewById(R.id.toolbar11);
        setSupportActionBar(toolbar);
        tvtitle = findViewById(R.id.toolbar_title11);
        tvtitle.setText("Mục 11: Giao Tiếp Bằng Lời");
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        radioGroup11 = findViewById(R.id.radioGroup_11);
        rdo_11giaotiepbangloi1 = findViewById(R.id.rdo11_radiobutton1  );
        rdo_11giaotiepbangloi15 = findViewById(R.id.rdo11_radiobutton15  );
        rdo_11giaotiepbangloi2 = findViewById(R.id.rdo11_radiobutton2  );
        rdo_11giaotiepbangloi25 = findViewById(R.id.rdo11_radiobutton25  );
        rdo_11giaotiepbangloi3 = findViewById(R.id. rdo11_radiobutton3 );
        rdo_11giaotiepbangloi35 = findViewById(R.id. rdo11_radiobutton35 );
        rdo_11giaotiepbangloi4 = findViewById(R.id. rdo11_radiobutton4 );



        radioGroup11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rdo_11giaotiepbangloi1.setBackgroundColor(Color.TRANSPARENT);
                rdo_11giaotiepbangloi15.setBackgroundColor(Color.TRANSPARENT);
                rdo_11giaotiepbangloi2.setBackgroundColor(Color.TRANSPARENT);
                rdo_11giaotiepbangloi25.setBackgroundColor(Color.TRANSPARENT);
                rdo_11giaotiepbangloi3.setBackgroundColor(Color.TRANSPARENT);
                rdo_11giaotiepbangloi35.setBackgroundColor(Color.TRANSPARENT);
                rdo_11giaotiepbangloi4.setBackgroundColor(Color.TRANSPARENT);
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

                radioGroup11.invalidate();


                switch (checkedId) {
                    case R.id.rdo11_radiobutton1:
                        diem11 = 1;
                        radioButton = findViewById(R.id.rdo11_radiobutton1);
                        break;
                    case R.id.rdo11_radiobutton15:
                        diem11 = 1.5;
                        radioButton = findViewById(R.id.rdo11_radiobutton15);
                        break;
                    case R.id.rdo11_radiobutton2:
                        diem11 = 2;
                        radioButton = findViewById(R.id.rdo11_radiobutton2);
                        break;
                    case R.id.rdo11_radiobutton25:
                        radioButton = findViewById(R.id.rdo11_radiobutton25);
                        diem11 = 2.5;
                        break;
                    case R.id.rdo11_radiobutton3:
                        diem11 = 3;
                        radioButton = findViewById(R.id.rdo11_radiobutton3);
                        break;
                    case R.id.rdo11_radiobutton35:
                        radioButton = findViewById(R.id.rdo11_radiobutton35);
                        diem11 = 3.5;
                        break;
                    case R.id.rdo11_radiobutton4:
                        radioButton = findViewById(R.id.rdo11_radiobutton4);
                        diem11 = 4;
                        break;
                    default:
                        diem11 = 0.0; // Giá trị mặc định của diem
                        radioButton = findViewById(R.id.rdo11_radiobutton1); // Không có RadioButton được chọn
                        break;
                }
                if (radioButton != null) {
                    radioButton.setChecked(true);
                }
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs11", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("checkedRadioButtonId", checkedId);
                editor.apply();

            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs11", MODE_PRIVATE);
        int checkedRadioButtonId = sharedPreferences.getInt("checkedRadioButtonId", -1);
        if (checkedRadioButtonId != -1) {
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            checkedRadioButton.setChecked(true);
        }

        btn = findViewById(R.id.btn_11);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup11.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    // Nếu không có radio button nào được chọn
                    Toast.makeText(activity_11giaotiepbangloi.this, "Vui lòng chọn một mục", Toast.LENGTH_SHORT).show();
                } else {
                    // Nếu có radio button được chọn
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedValue = selectedRadioButton.getText().toString();
                    Toast.makeText(activity_11giaotiepbangloi.this, "Bạn đã chọn: " + selectedValue, Toast.LENGTH_SHORT).show();
                    // gửi điểm
                    SharedPreferences sharedPreferences = getSharedPreferences("Form11", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putFloat("doubleValue11", (float) diem11);
                    editor.apply();
                    Intent intent = new Intent(activity_11giaotiepbangloi.this,activity_12giaotiepkhongloi.class);
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
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs11", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("checkedRadioButtonId", radioGroup11.getCheckedRadioButtonId());
        editor.apply();
    }

}