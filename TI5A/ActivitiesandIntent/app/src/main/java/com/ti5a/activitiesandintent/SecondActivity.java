package com.ti5a.activitiesandintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView tv_nama;
    private Button btn_selesai;
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv_nama = findViewById(R.id.tv_nama);
        btn_selesai = findViewById(R.id.btn_selesai);
        btn_selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG,"END SecondActivity");
                finish();
            }
        });
        Intent terima = getIntent();
        String nama = terima.getStringExtra("exNama");
        tv_nama.setText(nama);
        Log.d(LOG_TAG,"-----------------");
        Log.d(LOG_TAG,"OnCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"OnStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "OnPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"OnDestroy");
    }
}