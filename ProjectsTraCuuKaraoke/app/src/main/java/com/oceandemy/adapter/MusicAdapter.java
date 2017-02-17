package com.oceandemy.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.oceandemy.model.Music;
import com.oceandemy.projectstracuukaraoke.R;

import java.util.List;

/**
 * Created by duand on 08/02/2017.
 */

public class MusicAdapter extends ArrayAdapter<Music>
{

    Activity context;
    int resource;
    List<Music> objects;

    public MusicAdapter(Activity context, int resource, List<Music> objects)
    {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource,null);

        TextView txtMaBaiHat = (TextView) row.findViewById(R.id.txtMaBaiHat);
        TextView txtTenBaiHat = (TextView) row.findViewById(R.id.txtTenBaiHat);
        TextView txtTenCaSy = (TextView) row.findViewById(R.id.txtTenCaSy);
        ImageButton btnLike = (ImageButton) row.findViewById(R.id.btnLike);
        ImageButton btnDislike = (ImageButton) row.findViewById(R.id.btnDislike);

        final Music music = this.objects.get(position);

        txtMaBaiHat.setText(music.getMaBaiHat());
        txtTenBaiHat.setText(music.getTenBaiHat());
        txtTenCaSy.setText(music.getTenCaSy());

        if(music.isThich())
        {
            btnLike.setVisibility(View.INVISIBLE);
            btnDislike.setVisibility(View.VISIBLE);
        }
        else
        {
            btnLike.setVisibility(View.VISIBLE);
            btnDislike.setVisibility(View.INVISIBLE);
        }

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyThich(music);
            }
        });

        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyKhongThich(music);
            }
        });
        return row;
    }

    private void xuLyKhongThich(Music music)
    {
        music.setThich(false);
    }

    private void xuLyThich(Music music)
    {
        music.setThich(true);
    }
}
