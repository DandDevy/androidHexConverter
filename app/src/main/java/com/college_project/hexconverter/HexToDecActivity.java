package com.college_project.hexconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.college_project.hexconverter.activites.MainActivity;

public class HexToDecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hex_to_dec);
    }


    public void convertHexToDec(View view) {
    }


    /**
     * <p>swap converters</p>
     * @param view
     */
    public void swap(View view) {
        Intent MainActivityIntent = new Intent(this, MainActivity.class);

        startActivity(MainActivityIntent);
    }
}
