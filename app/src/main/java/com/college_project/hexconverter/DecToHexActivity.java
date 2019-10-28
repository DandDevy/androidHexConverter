package com.college_project.hexconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DecToHexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dec_to_hex);

        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(getIntent().getStringExtra("intValue"));
    }
}
