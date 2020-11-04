package com.ti5a.pesan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et_message;
    private Button btn_kirim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_message = findViewById(R.id.et_message);
        btn_kirim = findViewById(R.id.btn_kirim);
        btn_kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sebelah();
            }
        });
    }
    void sebelah(){
        String pesan = et_message.getText().toString();
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("data", pesan);
        startActivity(intent);

    }
}