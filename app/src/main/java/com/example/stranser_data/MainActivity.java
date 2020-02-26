package com.example.stranser_data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements TestClistener {
    private EditText etName;
    private EditText etAddress;
    private Button btSubmit;
    private SinhVien sinhVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflateView();
        setEvent();
    }

    private void setEvent() {
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String add = etAddress.getText().toString();
                sinhVien = new SinhVien(name,add);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.llFragment,TestFragment.newInstance(sinhVien),"testFragment")
                        .commit();
            }
        });
    }

    private void inflateView() {
        etName =findViewById(R.id.edInput);
        etAddress = findViewById(R.id.edAddress);
        btSubmit = findViewById(R.id.btnSubmit);
    }

    @Override
    public void onSendClick(SinhVien sinhVien) {
       // tvSend.setText(message);
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("SinhVien",sinhVien);
        startActivity(intent);
    }
}
interface TestClistener{
    void onSendClick(SinhVien sinhVien);
}