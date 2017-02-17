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
import android.widget.Toast;

import com.oceandemy.hoclistviewnangcao2.R;
import com.oceandemy.model.DanhBa;

import java.util.List;

/**
 * Created by duand on 06/02/2017.
 */

public class DanhBaAdapter extends ArrayAdapter<DanhBa>
{
    Activity context;   // Màn hình sử dụng giao diện này
    int resource;       //layout cho từng dòng hiển thị (làm theo khách hàng)
    List<DanhBa> objects; // Danh sách nguồn dữ liệu muốn hiển thị lên giao diện

    public DanhBaAdapter(Activity context, int resource, List<DanhBa> objects)
    {
        super(context, resource, objects);
        this.objects = objects;
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = this.context.getLayoutInflater();
        // LayoutInflater: dùng để build file giao diện (xml-textfile)
        // thành file mà hệ thống có thể hiểu được

        View row = inflater.inflate(this.resource,null);

        TextView txtTen = (TextView) row.findViewById(R.id.txtTen);
        TextView txtPhone = (TextView) row.findViewById(R.id.txtPhone);
        ImageButton btnCall = (ImageButton) row.findViewById(R.id.btnCall);
        ImageButton btnSMS = (ImageButton) row.findViewById(R.id.btnSMS);
        ImageButton btnDetail = (ImageButton) row.findViewById(R.id.btnDetail);

        final DanhBa danhBa = this.objects.get(position);

        txtTen.setText(danhBa.getTen());
        txtPhone.setText(danhBa.getPhone());

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyXemChiTiet(danhBa);
                
            }
        });

        return row;
    }

    private void xuLyXemChiTiet(DanhBa danhBa) {
        Toast.makeText(this.context,"Bạn chọn "+danhBa.getTen(),Toast.LENGTH_LONG).show();
    }
}
