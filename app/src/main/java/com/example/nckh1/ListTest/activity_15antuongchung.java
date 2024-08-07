package com.example.nckh1.ListTest;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
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

import com.example.nckh1.Ketqua.Ketqua_main;
import com.example.nckh1.R;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class activity_15antuongchung extends AppCompatActivity {
    private TextInputEditText edtDate;
    private Button btn, btntk;
    private double diem15 = 0;
    private TextView tvtitle;
    private RadioButton radioButton;
    private RadioGroup radioGroup15;
    private RadioButton rdo_15_1, rdo_15_15, rdo_15_2, rdo_15_25, rdo_15_3, rdo_15_35, rdo_15_4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity15antuongchung);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar = findViewById(R.id.toolbar15);
        setSupportActionBar(toolbar);
        tvtitle = findViewById(R.id.toolbar_title15);
        tvtitle.setText("Mục 15:Ấn Tượng Chung");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        edtDate = findViewById(R.id.edtDate);
        xulidate();
        radioGroup15 = findViewById(R.id.radioGroup_15);
        rdo_15_1 = findViewById(R.id.rdo15_radiobutton1);
        rdo_15_15 = findViewById(R.id.rdo15_radiobutton15);

        rdo_15_2 = findViewById(R.id.rdo15_radiobutton2);
        rdo_15_25 = findViewById(R.id.rdo15_radiobutton25);

        rdo_15_3 = findViewById(R.id.rdo15_radiobutton3);

        rdo_15_35 = findViewById(R.id.rdo15_radiobutton35);

        rdo_15_4 = findViewById(R.id.rdo15_radiobutton4);


        radioGroup15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdo_15_1.setBackgroundColor(Color.TRANSPARENT);
                rdo_15_15.setBackgroundColor(Color.TRANSPARENT);
                rdo_15_2.setBackgroundColor(Color.TRANSPARENT);
                rdo_15_25.setBackgroundColor(Color.TRANSPARENT);
                rdo_15_3.setBackgroundColor(Color.TRANSPARENT);
                rdo_15_35.setBackgroundColor(Color.TRANSPARENT);
                rdo_15_4.setBackgroundColor(Color.TRANSPARENT);
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

                radioGroup15.invalidate();
                switch (checkedId) {
                    case R.id.rdo15_radiobutton1:
                        diem15 = 1;
                        radioButton = findViewById(R.id.rdo15_radiobutton1);
                        break;
                    case R.id.rdo15_radiobutton15:
                        diem15 = 1.5;
                        radioButton = findViewById(R.id.rdo15_radiobutton15);
                        break;
                    case R.id.rdo15_radiobutton2:
                        diem15 = 2;
                        radioButton = findViewById(R.id.rdo15_radiobutton2);
                        break;
                    case R.id.rdo15_radiobutton25:
                        diem15 = 2.5;
                        radioButton = findViewById(R.id.rdo15_radiobutton25);
                        break;
                    case R.id.rdo15_radiobutton3:
                        radioButton = findViewById(R.id.rdo15_radiobutton3);
                        diem15 = 3;
                        break;
                    case R.id.rdo15_radiobutton35:
                        radioButton = findViewById(R.id.rdo15_radiobutton35);
                        diem15 = 3.5;
                        break;
                    case R.id.rdo15_radiobutton4:
                        radioButton = findViewById(R.id.rdo15_radiobutton4);
                        diem15 = 4;
                        break;
                    default:
                        diem15 = 0.0; // Giá trị mặc định của diem
                        radioButton = findViewById(R.id.rdo15_radiobutton1); // Không có RadioButton được chọn
                        break;
                }
                if (radioButton != null) {
                    radioButton.setChecked(true);
                }
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs15", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("checkedRadioButtonId", checkedId);
                editor.apply();

            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs15", MODE_PRIVATE);
        int checkedRadioButtonId = sharedPreferences.getInt("checkedRadioButtonId", -1);
        if (checkedRadioButtonId != -1) {
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            checkedRadioButton.setChecked(true);
        }

        btntk = findViewById(R.id.btntongket15);
        btntk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup15.getCheckedRadioButtonId();
                String edt = edtDate.getText().toString();

                if (selectedId == -1) {
                    // Nếu không có radio button nào được chọn
                    Toast.makeText(activity_15antuongchung.this, "Vui lòng chọn một mục", Toast.LENGTH_SHORT).show();
                } else if (edt.equals("")) {
                    Toast.makeText(activity_15antuongchung.this, "Vui lòng nhập ngày thực hiện", Toast.LENGTH_SHORT).show();
                } else {
                    // Nếu có radio button được chọn
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedValue = selectedRadioButton.getText().toString();
                    Toast.makeText(activity_15antuongchung.this, "Bạn đã chọn: " + selectedValue, Toast.LENGTH_SHORT).show();
                    // gửi điểm
                    SharedPreferences sharedPreferences = getSharedPreferences("Form15", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putFloat("doubleValue15", (float) diem15);
                    editor.apply();
                    senddate();
                    Intent intent = new Intent(activity_15antuongchung.this, Ketqua_main.class);
                    startActivity(intent);
                    finish();

                }

            }
        });


    }

    private void senddate() {
        String sendngaythuchien = edtDate.getText().toString();

        SharedPreferences sharedPreferencesns = getSharedPreferences("ns", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferencesns.edit();
        editor.putString("ns", sendngaythuchien);
        editor.apply();
    }

    private void xulidate() {
        // xử lý date
        edtDate = findViewById(R.id.edtDate);

// Khởi tạo DatePickerDialog với ngày hiện tại
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, yearSelected, monthOfYear, dayOfMonth) -> {
            // Xử lý khi người dùng chọn ngày
            calendar.set(yearSelected, monthOfYear, dayOfMonth);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
            String formattedDate = simpleDateFormat.format(calendar.getTime());
            edtDate.setText(formattedDate);
        }, year, month, day);

// Hiển thị DatePickerDialog khi EditText được nhấn
        edtDate.setOnClickListener(view -> datePickerDialog.show());
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Trong phương thức onPause()
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs15", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("checkedRadioButtonId", radioGroup15.getCheckedRadioButtonId());
        editor.apply();
    }
}