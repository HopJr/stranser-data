package com.example.stranser_data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private SinhVien sinhVien;
    private TextView tvName;
    private  TextView tvAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvName = findViewById(R.id.tvName);
        tvAdd = findViewById(R.id.tvAdd);
        sinhVien = (SinhVien) getIntent().getSerializableExtra("SinhVien");
        tvName.setText(sinhVien.getName());
        tvAdd.setText(sinhVien.getAdd());
    }
}
