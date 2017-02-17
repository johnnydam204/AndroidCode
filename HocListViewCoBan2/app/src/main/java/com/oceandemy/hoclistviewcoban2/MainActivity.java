package com.oceandemy.hoclistviewcoban2;

import android.opengl.EGLExt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrTen;
    ArrayAdapter<String> adapterTen;
    ListView lvTen;
    Button btnLuu;
    EditText txtTen;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyLuu();
            }
        });
    }

    private void XuLyLuu() {
        String ten = txtTen.getText().toString();
        arrTen.add(ten);
        adapterTen.notifyDataSetChanged();
        txtTen.setText("");
        txtTen.requestFocus();
    }

    private void addControls() {

        lvTen = (ListView) findViewById(R.id.lvTen);
        btnLuu = (Button) findViewById(R.id.btnLuu);
        txtTen = (EditText) findViewById(R.id.txtTen);

        arrTen = new ArrayList<String>();
        adapterTen = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrTen
        );

        lvTen.setAdapter(adapterTen);
    }
}
