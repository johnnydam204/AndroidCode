package com.oceandemy.duandh.hocimagebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton radNha, radNguoi;
    ImageView imgHinh;
    ImageButton btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();

    }

    private void addControls() {
        radNguoi = (RadioButton) findViewById(R.id.radNguoi);
        radNha = (RadioButton) findViewById(R.id.radNha);
        imgHinh = (ImageView) findViewById(R.id.imgHinh);
        btnThoat = (ImageButton) findViewById(R.id.btnThoat);
    }

    private void addEvents() {
        radNha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    imgHinh.setImageResource(R.drawable.house);
                }
            }
        });

        radNguoi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    imgHinh.setImageResource(R.drawable.employee);
                }
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
