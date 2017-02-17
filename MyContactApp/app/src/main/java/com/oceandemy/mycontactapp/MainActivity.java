package com.oceandemy.mycontactapp;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtPhone, txtSms;
    Button btnDial, btnCall, btnSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls() {
        txtPhone = (EditText) findViewById(R.id.txtPhone);
        txtSms = (EditText) findViewById(R.id.txtSms);
        btnCall = (Button) findViewById(R.id.btnCall);
        btnSms = (Button) findViewById(R.id.btnSms);
        btnDial = (Button) findViewById(R.id.btnDial);
    }

    private void addEvents() {
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyQuaySo();
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyGoiLuon();
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyGuiSms();
            }
        });
    }

    private void xuLyGuiSms() {
        final SmsManager sms = SmsManager.getDefault();
        //Intent smsSend  = new Intent("ACTION_MSG_SENT");

        Intent smsSend = new Intent(Intent.ACTION_SEND);

        final PendingIntent pendingSmsSend = PendingIntent.getBroadcast(this, 0, smsSend,0);

        registerReceiver(
                new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        int result = getResultCode();
                        String msg = "Send OK";
                        if (result != Activity.RESULT_OK)
                            msg = "Send failed";
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
                    }
                },
                new IntentFilter(Intent.ACTION_SEND))

        sms.sendTextMessage(txtPhone.getText().toString(),null,txtSms.getText().toString()+"",pendingSmsSend,null);
    }

    private void xuLyGoiLuon() {
        Uri uri = Uri.parse("tel:" + txtPhone.getText().toString());
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(uri);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }

    private void xuLyQuaySo() {
        Uri uri = Uri.parse("tel:"+txtPhone.getText().toString());
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(uri);
        startActivity(intent);
    }
}
