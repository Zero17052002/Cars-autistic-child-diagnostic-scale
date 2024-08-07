package com.example.nckh1.Child_information;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nckh1.MainActivity;
import com.example.nckh1.R;
import com.example.nckh1.SharedPreferences.DataLocalManager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Infomation extends AppCompatActivity {
    private RadioGroup rdogroupgioitinh, rdogroupcachsinh, rdogroupsinh, rdogroupthangsinh;
    private EditText edtms, edthovaten, edtngaysinh, edtnoio, edtnnb, edtnnm;
    private Button btnSave;
    private TextView hvt;
    private String datams, datahvt, datans, datagt, datanoio, datannb, datannm, datacs, datas, datatg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infomation);

        Toolbar toolbar = findViewById(R.id.toolbarInfomation);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        unit();

        edtms.setText(AppUntil.ms);
        edthovaten.setText(AppUntil.hovaten);
        edtngaysinh.setText(AppUntil.ngaysinh);
        edtnoio.setText(AppUntil.noio);
        edtnnb.setText(AppUntil.nnb);
        edtnnm.setText(AppUntil.nnm);

        Date();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMs();
                sethovaten();
                setns();
                setgt();
                setnoio();
                setnnb();
                setnnm();
                setcs();
                setsinh();
                setts();
                update();


                Intent intent = new Intent(Infomation.this, ShowInfomation.class);
                Toast.makeText(Infomation.this, "Lưu Thành Công", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        edtms.setText(AppUntil.ms);
        edthovaten.setText(AppUntil.hovaten);
        edtngaysinh.setText(AppUntil.ngaysinh);
        edtnoio.setText(AppUntil.noio);
        edtnnb.setText(AppUntil.nnb);
        edtnnm.setText(AppUntil.nnm);
    }

    private void update() {
        String updatems = edtms.getText().toString();
        AppUntil.ms = updatems;
        String updatehvt = edthovaten.getText().toString();
        AppUntil.hovaten = updatehvt;
        String updatens = edtngaysinh.getText().toString();
        AppUntil.ngaysinh = updatens;
        String updatenoio = edtnoio.getText().toString();
        AppUntil.noio = updatenoio;
        String updatennb = edtnnb.getText().toString();
        AppUntil.nnb = updatennb;
        String updatennm = edtnnm.getText().toString();
        AppUntil.nnm = updatennm;
        finish();
    }


    private void setMs() {
        datams = edtms.getText().toString();
        DataLocalManager.setStringMs(datams);
    }

    private void sethovaten() {
        datahvt = edthovaten.getText().toString();
        DataLocalManager.setStringhvt(datahvt);
    }

    private void setns() {
        datans = edtngaysinh.getText().toString();
        DataLocalManager.setStringns(datans);
    }

    private void setgt() {
        rdogroupgioitinh = findViewById(R.id.InfomationRadioGroupGioiTinh);
        int checkedRadioButtonId = rdogroupgioitinh.getCheckedRadioButtonId();

        if (checkedRadioButtonId != -1) {
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            String selectedOption = checkedRadioButton.getText().toString();
            DataLocalManager.setStringgt(selectedOption);
        }  // Không có RadioButton nào được chọn

    }

    private void setnoio() {
        datanoio = edtnoio.getText().toString();
        DataLocalManager.setStringnoio(datanoio);
    }

    private void setnnb() {
        datannb = edtnnb.getText().toString();
        DataLocalManager.setStringnnb(datannb);
    }

    private void setnnm() {
        datannm = edtnnm.getText().toString();
        DataLocalManager.setStringnnm(datannm);
    }

    private void setcs() {
        rdogroupcachsinh = findViewById(R.id.InfomationRadioGroupCachsinh);
        int checkedRadioButtonId = rdogroupcachsinh.getCheckedRadioButtonId();

        if (checkedRadioButtonId != -1) {
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            String selectedOption = checkedRadioButton.getText().toString();
            DataLocalManager.setStringcs(selectedOption);
        }  // Không có RadioButton nào được chọn
    }

    private void setsinh() {
        rdogroupsinh = findViewById(R.id.InfomationRadioGroupSinh);
        int checkedRadioButtonId = rdogroupsinh.getCheckedRadioButtonId();

        if (checkedRadioButtonId != -1) {
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            String selectedOption = checkedRadioButton.getText().toString();
            DataLocalManager.setStrings(selectedOption);
        }  // Không có RadioButton nào được chọn
    }

    private void setts() {
        rdogroupthangsinh = findViewById(R.id.InfomationRadioGroupThangSinh);
        int checkedRadioButtonId = rdogroupthangsinh.getCheckedRadioButtonId();

        if (checkedRadioButtonId != -1) {
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            String selectedOption = checkedRadioButton.getText().toString();
            DataLocalManager.setStringts(selectedOption);
        }  // Không có RadioButton nào được chọn
    }


    private void unit() {
        edtms = findViewById(R.id.InfomationMaSo);
        edthovaten = findViewById(R.id.InfomationHovaten);
        edtngaysinh = findViewById(R.id.InfomationNgaysinh);
        edtnoio = findViewById(R.id.InfomationNoio);
        edtnnb = findViewById(R.id.InfomationNNB);
        edtnnm = findViewById(R.id.InfomationNNM);

        rdogroupgioitinh = findViewById(R.id.InfomationRadioGroupGioiTinh);
        rdogroupcachsinh = findViewById(R.id.InfomationRadioGroupCachsinh);
        rdogroupsinh = findViewById(R.id.InfomationRadioGroupSinh);
        rdogroupthangsinh = findViewById(R.id.InfomationRadioGroupThangSinh);

        btnSave = findViewById(R.id.InfomationBTNLuuThongTin);

        hvt = findViewById(R.id.hvt);


    }

    private void Date() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, yearSelected, monthOfYear, dayOfMonth) -> {
            // Xử lý khi người dùng chọn ngày
            calendar.set(yearSelected, monthOfYear, dayOfMonth);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
            String formattedDate = simpleDateFormat.format(calendar.getTime());
            edtngaysinh.setText(formattedDate);
        }, year, month, day);

// Hiển thị DatePickerDialog khi EditText được nhấn
        edtngaysinh.setOnClickListener(view -> datePickerDialog.show());

    }
}