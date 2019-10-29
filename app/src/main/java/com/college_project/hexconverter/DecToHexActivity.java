package com.college_project.hexconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DecToHexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dec_to_hex);

        String intValueAsString = getIntent().getStringExtra("intValue");

        int intValue = Integer.valueOf(intValueAsString);

        String hexOfValue = Integer.toString(intValue, 16);

        TextView textView = (TextView) findViewById(R.id.hexValue);

        textView.setText(hexOfValue);
    }

}
