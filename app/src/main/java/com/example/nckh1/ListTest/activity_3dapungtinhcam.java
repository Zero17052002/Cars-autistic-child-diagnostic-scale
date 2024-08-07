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


public class activity_3dapungtinhcam extends AppCompatActivity {
    private Button btn;
    private double diem3 = 0;
    private TextView tvtitle;
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private RadioButton rdo_dutc1, rdo_dutc15, rdo_dutc2, rdo_dutc25, rdo_dutc3, rdo_dutc35, rdo_dutc4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3dapungtinhcam);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        tvtitle = findViewById(R.id.toolbar_title3);
        tvtitle.setText("Mục 3:Đáp Ứng Tình Cảm");
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        radioGroup = findViewById(R.id.radioGroup_dapungtinhcam3);
        rdo_dutc1 = findViewById(R.id.dapungtinhcam3_radiobutton1);
        rdo_dutc15 = findViewById(R.id.dapungtinhcam3_radiobuton15);
        rdo_dutc2 = findViewById(R.id.dapungtinhcam3_radiobuton2);
        rdo_dutc25 = findViewById(R.id.dapungtinhcam3_radiobuton25);
        rdo_dutc3 = findViewById(R.id.dapungtinhcam3_radiobuton3);
        rdo_dutc35 = findViewById(R.id.dapungtinhcam3_radiobuton35);
        rdo_dutc4 = findViewById(R.id.dapungtinhcam3_radiobuton4);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rdo_dutc1.setBackgroundColor(Color.TRANSPARENT);
                rdo_dutc15.setBackgroundColor(Color.TRANSPARENT);
                rdo_dutc2.setBackgroundColor(Color.TRANSPARENT);
                rdo_dutc25.setBackgroundColor(Color.TRANSPARENT);
                rdo_dutc3.setBackgroundColor(Color.TRANSPARENT);
                rdo_dutc35.setBackgroundColor(Color.TRANSPARENT);
                rdo_dutc4.setBackgroundColor(Color.TRANSPARENT);
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
                    case R.id.dapungtinhcam3_radiobutton1:
                        diem3 = 1;
                        radioButton = findViewById(R.id.dapungtinhcam3_radiobutton1);
                        break;
                    case R.id.dapungtinhcam3_radiobuton15:
                        diem3 = 1.5;
                        radioButton = findViewById(R.id.dapungtinhcam3_radiobuton15);
                        break;
                    case R.id.dapungtinhcam3_radiobuton2:
                        diem3 = 2;
                        radioButton = findViewById(R.id.dapungtinhcam3_radiobuton2);
                        break;
                    case R.id.dapungtinhcam3_radiobuton25:
                        diem3 = 2.5;
                        radioButton = findViewById(R.id.dapungtinhcam3_radiobuton25);
                        break;
                    case R.id.dapungtinhcam3_radiobuton3:
                        diem3 = 3;
                        radioButton = findViewById(R.id.dapungtinhcam3_radiobuton3);
                        break;
                    case R.id.dapungtinhcam3_radiobuton35:
                        diem3 = 3.5;
                        radioButton = findViewById(R.id.dapungtinhcam3_radiobuton35);
                        break;
                    case R.id.dapungtinhcam3_radiobuton4:
                        diem3 = 4;
                        radioButton = findViewById(R.id.dapungtinhcam3_radiobuton4);
                        break;
                    default:
                        diem3= 0.0; // Giá trị mặc định của diem
                        radioButton = findViewById(R.id.dapungtinhcam3_radiobutton1); // Không có RadioButton được chọn
                        break;
                }
                if (radioButton != null) {
                    radioButton.setChecked(true);
                }
                SharedPreferences sharedPreferences = getSharedPreferences("thu3", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("checkedRadioButtonId", checkedId);
                editor.apply();

            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("thu3", MODE_PRIVATE);
        int checkedRadioButtonId = sharedPreferences.getInt("checkedRadioButtonId", -1);
        if (checkedRadioButtonId != -1) {
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            checkedRadioButton.setChecked(true);
        }

        btn = findViewById(R.id.btn_dapungtinhcam3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    // Nếu không có radio button nào được chọn
                    Toast.makeText(activity_3dapungtinhcam.this, "Vui lòng chọn một mục", Toast.LENGTH_SHORT).show();
                } else {
                    // Nếu có radio button được chọn
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedValue = selectedRadioButton.getText().toString();
                    Toast.makeText(activity_3dapungtinhcam.this, "Bạn đã chọn: " + selectedValue, Toast.LENGTH_SHORT).show();

                    // gửi điểm
                    SharedPreferences sharedPreferences = getSharedPreferences("Form3", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putFloat("doubleValue3", (float) diem3);
                    editor.apply();
                    Intent intent = new Intent(activity_3dapungtinhcam.this, activity_4cactacdongcothe.class);
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
        SharedPreferences sharedPreferences = getSharedPreferences("thu3", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("checkedRadioButtonId", radioGroup.getCheckedRadioButtonId());
        editor.apply();
    }

}