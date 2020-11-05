package com.ti5a.hellotoastlinier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnToast;
    private Button btnCount;
    private TextView tvCount;
    private int mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnToast = findViewById(R.id.btn_toast);
        btnCount = findViewById(R.id.btn_count);
        tvCount = findViewById((R.id.tv_count));

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kejadian kalo tombol toast diklik
                Toast.makeText(MainActivity.this, "Ini adalah Toast", Toast.LENGTH_SHORT).show();
            }
        });
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++mCount;
                if(tvCount!=null)
                {
                    tvCount.setText(Integer.toString(mCount));
                }
            }
        });
    }

}