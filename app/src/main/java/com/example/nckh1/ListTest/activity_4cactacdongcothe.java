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


public class activity_4cactacdongcothe extends AppCompatActivity {
    private Button btn;
    private double diem4 = 0;
    private TextView tvtitle;
    private RadioButton radioButton;
    private RadioGroup radioGroup4;
    private RadioButton rdo_ctdct1, rdo_ctdct15, rdo_ctdct2, rdo_ctdct25, rdo_ctdct3, rdo_ctdct35, rdo_ctdct4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4cactacdongcothe);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar = findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        tvtitle = findViewById(R.id.toolbar_title4);
        tvtitle.setText("Mục 4: Tác động cơ thể");
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        radioGroup4 = findViewById(R.id.radioGroup_cactacdongcothe4);
        rdo_ctdct1 = findViewById(R.id.cactacdongcothe4_radiobutton1);
        rdo_ctdct15 = findViewById(R.id.cactacdongcothe4_radiobuton15);
        rdo_ctdct2 = findViewById(R.id.cactacdongcothe4_radiobuton2);
        rdo_ctdct25 = findViewById(R.id.cactacdongcothe4_radiobuton25);
        rdo_ctdct3 = findViewById(R.id.cactacdongcothe4_radiobuton3);
        rdo_ctdct35 = findViewById(R.id.cactacdongcothe4_radiobuton35);
        rdo_ctdct4 = findViewById(R.id.cactacdongcothe4_radiobuton4);

        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdo_ctdct1.setBackgroundColor(Color.TRANSPARENT);
                rdo_ctdct15.setBackgroundColor(Color.TRANSPARENT);
                rdo_ctdct2.setBackgroundColor(Color.TRANSPARENT);
                rdo_ctdct25.setBackgroundColor(Color.TRANSPARENT);
                rdo_ctdct3.setBackgroundColor(Color.TRANSPARENT);
                rdo_ctdct35.setBackgroundColor(Color.TRANSPARENT);
                rdo_ctdct4.setBackgroundColor(Color.TRANSPARENT);
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

                radioGroup4.invalidate();
                switch (checkedId) {
                    case R.id.cactacdongcothe4_radiobutton1:
                        diem4 = 1;
                        radioButton = findViewById(R.id.cactacdongcothe4_radiobutton1);
                        break;
                    case R.id.cactacdongcothe4_radiobuton15:
                        diem4 = 1.5;
                        radioButton = findViewById(R.id.cactacdongcothe4_radiobuton15);
                        break;
                    case R.id.cactacdongcothe4_radiobuton2:
                        diem4 = 2;
                        radioButton = findViewById(R.id.cactacdongcothe4_radiobuton2);
                        break;
                    case R.id.cactacdongcothe4_radiobuton25:
                        diem4 = 2.5;
                        radioButton = findViewById(R.id.cactacdongcothe4_radiobuton25);
                        break;
                    case R.id.cactacdongcothe4_radiobuton3:
                        diem4 = 3;
                        radioButton = findViewById(R.id.cactacdongcothe4_radiobuton3);
                        break;
                    case R.id.cactacdongcothe4_radiobuton35:
                        diem4 = 3.5;
                        radioButton = findViewById(R.id.cactacdongcothe4_radiobuton35);
                        break;
                    case R.id.cactacdongcothe4_radiobuton4:
                        diem4 = 4;
                        radioButton = findViewById(R.id.cactacdongcothe4_radiobuton4);
                        break;

                    default:
                        diem4 = 0.0; // Giá trị mặc định của diem
                        radioButton = findViewById(R.id.cactacdongcothe4_radiobutton1); // Không có RadioButton được chọn
                        break;
                }
                if (radioButton != null) {
                    radioButton.setChecked(true);
                }
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs4", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("checkedRadioButtonId", checkedId);
                editor.apply();

            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs4", MODE_PRIVATE);
        int checkedRadioButtonId = sharedPreferences.getInt("checkedRadioButtonId", -1);
        if (checkedRadioButtonId != -1) {
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            checkedRadioButton.setChecked(true);
        }
        btn = findViewById(R.id.btn_cactacdongcothe4);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup4.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    // Nếu không có radio button nào được chọn
                    Toast.makeText(activity_4cactacdongcothe.this, "Vui lòng chọn một mục", Toast.LENGTH_SHORT).show();
                } else {
                    // Nếu có radio button được chọn
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedValue = selectedRadioButton.getText().toString();
                    Toast.makeText(activity_4cactacdongcothe.this, "Bạn đã chọn: " + selectedValue, Toast.LENGTH_SHORT).show();
                    // gửi điểm
                    SharedPreferences sharedPreferences = getSharedPreferences("Form4", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putFloat("doubleValue4", (float) diem4);
                    editor.apply();
                    Intent intent = new Intent(activity_4cactacdongcothe.this, activity_5sudungdovat.class);
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
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs4", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("checkedRadioButtonId", radioGroup4.getCheckedRadioButtonId());
        editor.apply();
    }

}