package com.college_project.hexconverter.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.college_project.hexconverter.R;
import com.college_project.hexconverter.controllers.HexConverter;
import  com.college_project.hexconverter.controllers.InputValidation;

public class HexToDecActivity extends AppCompatActivity {

    public static final String STRING_OF_INT_CONVERTED_FROM_HEX_INTENT_NAME = "convertedHexToInt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hex_to_dec);
    }


    public void convertHexToDec(View view) {
        String hexValueAsString = ((EditText) findViewById(R.id.hexValue)).getText().toString();
        if(InputValidation.isStringConvertibleFromHexToDec(hexValueAsString)){

            String conversionResult = HexConverter.stringOfHexToStringOfInt(hexValueAsString);

            Intent convertHexToDec = new Intent(this, MainActivity.class);
            convertHexToDec.putExtra(STRING_OF_INT_CONVERTED_FROM_HEX_INTENT_NAME, conversionResult);
            startActivity(convertHexToDec);
        }
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
