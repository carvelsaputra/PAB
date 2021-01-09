package com.ti5a.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

public class MainActivity extends AppCompatActivity {
    private EditText mWebsiteEditText;
    private Button mWebsiteButton;

    private EditText mLocationEditText;
    private Button mLocationButton;

    private EditText mShareTextEditText;
    private Button mShareTextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebsiteEditText = findViewById(R.id.website_edittext);
        mWebsiteButton = findViewById(R.id.open_website_button);


        mWebsiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = mWebsiteEditText.getText().toString();
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("ImplicitIntents", "Can't handle this");
                }
            }
        });

        mLocationEditText = findViewById(R.id.location_edittext);
        mLocationButton = findViewById(R.id.open_location_button);
        mLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loc = mLocationEditText.getText().toString();
                Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
                Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                    ;
                } else {
                    Log.d("ImplicitIntents", "Can't handle this");
                }
            }
        });

        mShareTextEditText = findViewById(R.id.share_edittext);
        mShareTextButton = findViewById(R.id.share_text_button);
        mShareTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = mShareTextEditText.getText().toString();
                String mimeType = "text/plain";
                ShareCompat.IntentBuilder
                        .from(MainActivity.this)
                        .setType(mimeType)
                        .setChooserTitle("Share this text with: ")
                        .setText(txt)
                        .startChooser();
            }
        });
    }
}