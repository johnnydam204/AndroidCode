package com.oceandemy.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.oceandemy.hoclistviewnangcao.R;
import com.oceandemy.model.DanhBa;

import java.util.List;

/**
 * Created by duand on 05/02/2017.
 */

public class DanhBaAdapter extends ArrayAdapter<DanhBa> {

    Activity context;
    int resource;
    List<DanhBa> objects;
    public DanhBaAdapter(Activity context, int resource, List<DanhBa> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource,null);

        TextView txtTen = (TextView) row.findViewById(R.id.txtName);
        TextView txtPhone = (TextView) row.findViewById(R.id.txtPhone);
        ImageButton btnCall = (ImageButton) row.findViewById(R.id.btnCall);
        ImageButton btnSMS = (ImageButton) row.findViewById(R.id.btnSMS);
        ImageButton btnDetail = (ImageButton) row.findViewById(R.id.btnDetail);

        DanhBa danhBa = this.objects.get(position);

        txtTen.setText(danhBa.getTen());
        txtPhone.setText(danhBa.getPhone());

        return row;
    }
}
