package com.oceandemy.hoclistviewnangcao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.oceandemy.adapter.DanhBaAdapter;
import com.oceandemy.model.DanhBa;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView lvDanhBa;
    ArrayList<DanhBa> dsDanhBa;
    DanhBaAdapter danhBaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls() {
        lvDanhBa = (ListView) findViewById(R.id.lvDanhBa);
        dsDanhBa = new ArrayList<>();

        dsDanhBa.add(new DanhBa(1,"Nguyễn Văn Tèo","0986320486"));
        dsDanhBa.add(new DanhBa(2,"Nguyễn Văn Tôi","0983453586"));
        dsDanhBa.add(new DanhBa(3,"Nguyễn Văn Mai","0985332686"));

        danhBaAdapter = new DanhBaAdapter(
                MainActivity.this,
                R.layout.item,
                dsDanhBa);
        lvDanhBa.setAdapter(danhBaAdapter);
    }

    private void addEvents() {

    }
}
