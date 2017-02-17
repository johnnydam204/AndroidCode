package com.oceandemy.hoclistviewnangcao2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.oceandemy.adapter.DanhBaAdapter;
import com.oceandemy.model.DanhBa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

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

    private void addEvents() {

    }

    private void addControls() {
        lvDanhBa = (ListView) findViewById(R.id.lvDanhBa);
        dsDanhBa = new ArrayList<DanhBa>();

        dsDanhBa.add(new DanhBa(1,"Trần Thị Thúy","0912243454"));
        dsDanhBa.add(new DanhBa(2,"Hoàng Văn Quềnh","0982453454"));
        dsDanhBa.add(new DanhBa(3,"Đàm Hồng Diễm","0986320486"));

        danhBaAdapter = new DanhBaAdapter(
                MainActivity.this,
                R.layout.item,
                dsDanhBa
        );

        lvDanhBa.setAdapter(danhBaAdapter);
    }
}
