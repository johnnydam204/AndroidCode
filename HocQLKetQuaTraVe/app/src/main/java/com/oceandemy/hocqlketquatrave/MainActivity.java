package com.oceandemy.hocqlketquatrave;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtA, txtB, txtC;
    Button btnXuLy;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLy();
            }
        });
    }

    private void xuLy() {
        Intent myIntent = new Intent(MainActivity.this,XuLyActivity.class);

        myIntent.putExtra("a",Integer.parseInt(txtA.getText().toString()));
        myIntent.putExtra("b",Integer.parseInt(txtB.getText().toString()));
        myIntent.putExtra("c",Integer.parseInt(txtC.getText().toString()));

        //Bước 1: phải gọi startActivityForResult();
        // Đối số 1: Intent cần gửi đi
        // Đối số 2: Mã yêu cầu (là số nguyên, tùy chọn)
        startActivityForResult(myIntent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == 2)
        {
            txtKetQua.setText(data.getStringExtra("s"));
        }
    }

    private void addControls()
    {
        txtA = (EditText) findViewById(R.id.txtA);
        txtB = (EditText) findViewById(R.id.txtB);
        txtC = (EditText) findViewById(R.id.txtC);
        btnXuLy = (Button) findViewById(R.id.btnXuLy);
        txtKetQua = (TextView) findViewById(R.id.txtKetQua);

    }
}
