package com.ti5a.twoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonMain;
    private EditText editTextMain;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.ti5a.twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private TextView textHeaderReply;
    private TextView textMessageReply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextMain = findViewById(R.id.editText_main);
        buttonMain = findViewById(R.id.button_main);
        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextMain.getText().toString();
                Log.d(LOG_TAG, "Button clicked");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivityForResult(intent, TEXT_REQUEST);
            }
        });
        textHeaderReply = findViewById(R.id.text_header_reply);
        textMessageReply = findViewById(R.id.text_message_reply);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                textHeaderReply.setVisibility(View.VISIBLE);
                textMessageReply.setText(reply);
                textMessageReply.setVisibility(View.VISIBLE);
            }
        }
    }
}