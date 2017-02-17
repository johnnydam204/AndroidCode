package com.oceandemy.duand.hoccheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox chkAndroid, chkIOS, chkWinPhone, chkBlackBerry;
    Button btnXacNhan;
    TextView txtMonHoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls() {
        chkAndroid = (CheckBox) findViewById(R.id.chkAndroid);
        chkIOS = (CheckBox) findViewById(R.id.chkIOS);
        chkWinPhone = (CheckBox) findViewById(R.id.chkWinPhone);
        chkBlackBerry = (CheckBox) findViewById(R.id.chkBlackBerry);
        btnXacNhan = (Button) findViewById(R.id.btnXacNhan);
        txtMonHoc = (TextView) findViewById(R.id.txtMonHoc);
    }

    private void addEvents() {
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyLuaChon();
            }
        });

    }

    private void XuLyLuaChon() {
        
        String s="";

        if(chkAndroid.isChecked())
        {
            s += chkAndroid.getText().toString()+"\n";
        }
        if(chkIOS.isChecked())
        {
            s += chkIOS.getText().toString()+"\n";
        }
        if(chkWinPhone.isChecked())
        {
            s += chkWinPhone.getText().toString()+"\n";
        }
        if(chkBlackBerry.isChecked())
        {
            s += chkBlackBerry.getText().toString()+"\n";
        }

        txtMonHoc.setText(s);
    }
}
