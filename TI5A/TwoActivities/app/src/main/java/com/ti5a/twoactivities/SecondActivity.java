package com.ti5a.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textMessage;
    private EditText editTextSecond;
    private Button buttonSecond;
    public static final String EXTRA_REPLY = "com.ti5a.twoactivities.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textMessage = findViewById(R.id.text_message);

        Intent accept = getIntent();
        String message = accept.getStringExtra(MainActivity.EXTRA_MESSAGE);

        textMessage = findViewById(R.id.text_message);
        textMessage.setText(message);

        editTextSecond = findViewById(R.id.editText_second);
        buttonSecond = findViewById(R.id.button_second);
        buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reply = editTextSecond.getText().toString();
                Intent replyIntent = new Intent();
                replyIntent.putExtra(EXTRA_REPLY, reply);
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });


    }
}