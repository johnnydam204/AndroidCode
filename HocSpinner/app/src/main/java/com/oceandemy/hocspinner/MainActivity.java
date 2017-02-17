package com.oceandemy.hocspinner;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.oceandemy.model.NhanVien;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtTen, txtSoNgayCongTac;
    Spinner spThu;
    Button btnXacNhan;

    ArrayList<String> arrThu;
    ArrayAdapter<String> adapterThu;

    int lastSelected = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addControls() {
        txtTen = (EditText) findViewById(R.id.txtTen);
        txtSoNgayCongTac = (EditText) findViewById(R.id.txtSoNgay);
        btnXacNhan = (Button) findViewById(R.id.btnXacNhan);
        spThu = (Spinner) findViewById(R.id.spThu);

        arrThu = new ArrayList<>();
        arrThu.add("Thứ Hai");
        arrThu.add("Thứ Ba");
        arrThu.add("Thứ Tư");
        arrThu.add("Thứ Năm");
        arrThu.add("Thứ Sáu");
        arrThu.add("Thứ Bảy");
        arrThu.add("Chủ nhật");

        adapterThu = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_spinner_item,
                arrThu);

        adapterThu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spThu.setAdapter(adapterThu);
    }

    private void addEvents() {
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyXacNhan();
            }
        });

        spThu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Bạn chọn:" +arrThu.get(position),Toast.LENGTH_LONG).show();
                lastSelected = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void xuLyXacNhan() {
        if(lastSelected == -1) {
            Toast.makeText(MainActivity.this, "Chưa chọn thứ", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            NhanVien nhanVien = new NhanVien();

            nhanVien.setTenNhanVien(txtTen.getText().toString());
            nhanVien.setSoNgayCongTac(Integer.parseInt(txtSoNgayCongTac.getText().toString()));
            nhanVien.setThuBatDauCongTac(arrThu.get(lastSelected));

            Toast.makeText(MainActivity.this,nhanVien.toString(),Toast.LENGTH_LONG).show();
        }
    }
}
