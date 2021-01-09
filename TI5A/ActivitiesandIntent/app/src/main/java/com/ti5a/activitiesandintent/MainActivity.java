package com.ti5a.activitiesandintent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnPindah;
    private EditText etNama;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPindah = findViewById(R.id.btn_pindah);
        etNama = findViewById(R.id.et_nama);

        btnPindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNama.getText().toString();
                Intent pindah = new Intent(MainActivity.this, SecondActivity.class);
                pindah.putExtra("exNama", nama);
                startActivity(pindah);
//                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
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