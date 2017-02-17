package com.oceandemy.hocqlketquatrave;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class XuLyActivity extends AppCompatActivity
{

    TextView txtDoiSo;
    Button btnGiaiPhuongTrinh;
    Intent intent;

    int a, b, c;
    Double delta, x1, x2, x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_xu_ly);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnGiaiPhuongTrinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyGiaiPhuongTrinh();
            }
        });

    }

    private void xuLyGiaiPhuongTrinh()
    {
        if(a == 0)
        {
            x = Double.valueOf(-c)/b;
            //intent.putExtra("x",x);
            intent.putExtra("s","Phương trình bậc nhất \n x = "+x);

        }
        else
        {
            delta = Double.valueOf(b*b - 4*a*c);
            if(delta <0)
            {
                intent.putExtra("s","Phương trình vô nghiệm");
            }
            else if(delta == 0)
            {
                x = Double.valueOf(-b)/(2*a);
                intent.putExtra("s","Phương trình có nghiệm kép \n x= " + x);
                //intent.putExtra("x",x);
            }
            else
            {
                x1 = (-b + Math.sqrt(delta))/(2*a);
                x2 = (-b - Math.sqrt(delta))/(2*a);

                intent.putExtra("s","Phương trình có nghiệm phân biệt \n x1 = "+x1 + "\n x2 = "+x2);
                //intent.putExtra("x1",x1);
                //intent.putExtra("x2",x2);
            }
        }

        setResult(2,intent);
        // Đóng màn hình này lại để MainActivity trở lại ForceGround life time
        // vì nó chỉ tự động nhận được kết quả trả về từ forceground life time
        finish();
    }

    private void addControls() {
        txtDoiSo = (TextView) findViewById(R.id.txtDoiSo);
        btnGiaiPhuongTrinh = (Button) findViewById(R.id.btnGiaiPhuongTrinh);

        // Bước 2: Lấy Intent ra
        intent = getIntent();

        a = intent.getIntExtra("a",0);
        b = intent.getIntExtra("b",0);
        c = intent.getIntExtra("c",0);

        txtDoiSo.setText(
                "a = " + a + "\n" +
                "b = " + b + "\n" +
                "c = " + c);
    }
}
