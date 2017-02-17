package com.oceandemy.projectstracuukaraoke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

import com.oceandemy.adapter.MusicAdapter;
import com.oceandemy.model.Music;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    ListView lvBaiHatGoc;
    ArrayList<Music> dsBaiHatGoc;
    MusicAdapter adapterBaiHatGoc;

    ListView lvBaiHatYeuThich;
    ArrayList<Music> dsBaiHatYeuThich;
    MusicAdapter adapterBaiHatYeuThic;

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvemnts();
    }

    private void addEvemnts()
    {
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if(tabId.equals("t1"))
                    xuLyHienThiBaiHatGoc();
                else if(tabId.equals("t2"))
                    xuLyHienThiBaiHatYeuThich();

            }
        });
    }

    private void xuLyHienThiBaiHatYeuThich()
    {
        dsBaiHatYeuThich.clear();
        for(Music music:dsBaiHatGoc)
        {
            if(music.isThich())
                dsBaiHatYeuThich.add(music);
        }
        adapterBaiHatYeuThic.notifyDataSetChanged();
    }

    private void xuLyHienThiBaiHatGoc() 
    {
        adapterBaiHatGoc.notifyDataSetChanged();
    }

    private void addControls()
    {
        // Thiết lập TabHost
        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("t1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("",getResources().getDrawable(R.drawable.music));
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("t2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator("",getResources().getDrawable(R.drawable.favorite));
        tabHost.addTab(tab2);

        // Thiết lập ListView
        lvBaiHatGoc = (ListView) findViewById(R.id.lvBaiHatGoc);
        dsBaiHatGoc = new ArrayList<>();
        adapterBaiHatGoc = new MusicAdapter(
                MainActivity.this,
                R.layout.item,
                dsBaiHatGoc
        );
        lvBaiHatGoc.setAdapter(adapterBaiHatGoc);

        lvBaiHatYeuThich = (ListView) findViewById(R.id.lvBaiHatYeuThich);
        dsBaiHatYeuThich = new ArrayList<>();
        adapterBaiHatYeuThic = new MusicAdapter(
                MainActivity.this,
                R.layout.item,
                dsBaiHatYeuThich
        );
        lvBaiHatYeuThich.setAdapter(adapterBaiHatYeuThic);

        giaLapBaiHat();

    }

    private void giaLapBaiHat()
    {
        dsBaiHatGoc.add(new Music("00001","Thuyền và Biển","Anh Thơ",false));
        dsBaiHatGoc.add(new Music("00002","Một Mình","Quang Dũng",false));
        dsBaiHatGoc.add(new Music("00003","Ngẫu hứng Sông Hồng","Phạm Anh Khoa",false));
        dsBaiHatGoc.add(new Music("00004","Trái tim bên lề","Bằng Kiều",false));
        dsBaiHatGoc.add(new Music("00005","Đêm Đông","Đàm Vĩnh Hưng",false ));

        adapterBaiHatGoc.notifyDataSetChanged();
    }
}
