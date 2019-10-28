package com.college_project.hexconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convertDecToHex(View view) {
        String intValue = ((EditText) findViewById(R.id.intValue)).getText().toString();

        Intent decToHexConverter = new Intent(this, DecToHexActivity.class);

        decToHexConverter.putExtra("intValue", intValue);

        startActivity(decToHexConverter);
    }
}
